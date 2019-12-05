package cn.conque;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import com.alibaba.csp.sentinel.slots.system.SystemRuleManager;

import java.util.ArrayList;
import java.util.List;

/*
 * https://github.com/alibaba/Sentinel/wiki/%E5%A6%82%E4%BD%95%E4%BD%BF%E7%94%A8
 */
public class Test {

    //抛出异常的方式定义资源
    public static void main(String[] args) {
        initFlowRules();
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
            /*您的业务逻辑 - 开始*/
                System.out.println("hello world");
            /*您的业务逻辑 - 结束*/
            } catch (BlockException e1) {
            /*流控逻辑处理 - 开始*/
                System.out.println("block!");
            /*流控逻辑处理 - 结束*/
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }

    /*
    *流控规则:
    *
    * resource	资源名，资源名是限流规则的作用对象
    * count	限流阈值,过流控规则来指定允许该资源通过的请求次数，例如下面的代码定义了资源 HelloWorld 每秒最多只能通过 20 个请求。
    * grade	限流阈值类型，QPS 模式（1）或并发线程数模式（0）
    * limitApp	流控针对的调用来源	default，代表不区分调用来源
    * strategy	调用关系限流策略：直接、链路、关联	根据资源本身（直接）
    * controlBehavior	流控效果（直接拒绝 / 排队等待 / 慢启动模式），不支持按调用关系限流	直接拒绝
    *
    */
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }


    /*
     *熔断降级规则:
     *
     * resource	资源名，即限流规则的作用对象
     * 异count	阈值
     * grade	熔断策略，支持秒级 RT/秒级异常比例/分钟级异常数	秒级平均 RT
     * timeWindow	降级的时间，单位为 s
     * rtSlowRequestAmount	RT 模式下 1 秒内连续多少个请求的平均 RT 超出阈值方可触发熔断（1.7.0 引入）minRequestAmount	异常熔断的触发最小请求数，请求数小于该值时即使异常比率超出阈值也不会熔断（1.7.0 引入）
     *
     */
    private void initDegradeRule() {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource("HelloWorld");
        // set threshold RT, 10 ms
        rule.setCount(20);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule.setTimeWindow(20);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }

     /*
     * 系统保护规则:
     *
     * highestSystemLoad	最大的 load1，参考值	-1 (不生效)
     * avgRt	所有入口流量的平均响应时间	-1 (不生效)
     * maxThread	入口流量的最大并发数	-1 (不生效)
     * qps	所有入口资源的 QPS	-1 (不生效)
     * highestCpuUsage	当前系统的 CPU 使用率（0.0-1.0）	-1 (不生效)
     */
    private void initSystemRule() {
        List<SystemRule> rules = new ArrayList<>();
        SystemRule rule = new SystemRule();
        rule.setHighestSystemLoad(20);
        rules.add(rule);
        SystemRuleManager.loadRules(rules);
    }



}
