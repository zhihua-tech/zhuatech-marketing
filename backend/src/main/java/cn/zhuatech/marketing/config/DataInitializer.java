/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.marketing.config;
import cn.zhuatech.marketing.model.*;
import cn.zhuatech.marketing.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Configuration public class DataInitializer {
    @Bean CommandLineRunner seed(BusinessRecordRepository records,SystemSettingRepository settings){return args->{
        if(records.count()>0)return;
            settings.save(new SystemSetting("defaultTimezone","Asia/Shanghai"));
    settings.save(new SystemSetting("consentRequired","是"));
    settings.save(new SystemSetting("leadThreshold","70"));
    settings.save(new SystemSetting("attributionWindow","30天"));
            records.save(new BusinessRecord("MKT-20260826-001","CAMPAIGN","中小企业AI转型线上活动","中小企业决策人","增长经理","运行中",new BigDecimal("180000"),600,LocalDate.now().plusDays(14),"正常","官网、公众号和直播渠道同步触达"));
    records.save(new BusinessRecord("MKT-20260826-002","SEGMENT","制造业数字化潜客人群","华东制造业客户","数据运营","计划中",new BigDecimal("0"),1280,LocalDate.now().plusDays(4),"正常","已完成身份合并与退订过滤"));
    records.save(new BusinessRecord("MKT-20260826-003","JOURNEY","官网留资七日培育旅程","官网新增线索","营销运营","已暂停",new BigDecimal("36000"),420,LocalDate.now().plusDays(1),"关注","短信节点等待合规复核"));
    records.save(new BusinessRecord("MKT-20260826-004","LEAD","软件外包商机转化复盘","高意向商机","销售运营","已完成",new BigDecimal("92000"),86,LocalDate.now().plusDays(-7),"正常","形成18条销售认可线索"));
    };}
}
