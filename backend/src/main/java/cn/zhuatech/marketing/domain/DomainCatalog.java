/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.marketing.domain;
import org.springframework.stereotype.Component;
import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Component
public class DomainCatalog {
    private final Map<String,WorkflowAction> actions=new LinkedHashMap<>();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DomainCatalog(){
        actions.put("PLAN", new WorkflowAction("PLAN", "确认计划", List.of("草稿"), "计划中"));
actions.put("LAUNCH", new WorkflowAction("LAUNCH", "上线运行", List.of("计划中", "已暂停"), "运行中"));
actions.put("PAUSE", new WorkflowAction("PAUSE", "暂停活动", List.of("运行中"), "已暂停"));
actions.put("COMPLETE", new WorkflowAction("COMPLETE", "结束复盘", List.of("运行中"), "已完成"));
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String systemName(){return "知华科技营销自动化与客户旅程系统";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String scene(){return "营销活动、客户分群、自动化旅程、渠道触达、线索培育和归因分析";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String initialStatus(){return "草稿";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String partyLabel(){return "目标人群/渠道";} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String amountLabel(){return "活动预算";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String quantityLabel(){return "目标线索";} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String dueLabel(){return "上线日期";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public List<ModuleDefinition> modules(){return List.of(
        new ModuleDefinition("CAMPAIGN","营销活动","制定目标、预算、渠道和内容计划"),
    new ModuleDefinition("SEGMENT","客户分群","按属性、行为和交易条件管理人群"),
    new ModuleDefinition("JOURNEY","自动化旅程","编排触发、等待、分支和多渠道动作"),
    new ModuleDefinition("LEAD","线索与归因","跟踪线索评分、转化和活动贡献")
    );}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Map<String,WorkflowAction> actions(){return Collections.unmodifiableMap(actions);}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ModuleDefinition(String code,String name,String description){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record WorkflowAction(String code,String label,List<String> from,String to){}
}
