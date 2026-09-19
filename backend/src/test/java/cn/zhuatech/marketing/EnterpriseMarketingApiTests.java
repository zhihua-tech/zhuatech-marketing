/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.marketing;
import org.junit.jupiter.api.Test;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;import org.springframework.http.MediaType;import org.springframework.test.web.servlet.MockMvc;import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@SpringBootTest @AutoConfigureMockMvc class EnterpriseMarketingApiTests {@Autowired MockMvc mvc;
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void consentSuppressionFrequencyAndForecastAreApplied() throws Exception {mvc.perform(post("/api/enterprise/marketing/delivery-plan").with(httpBasic("operator","operator123")).contentType(MediaType.APPLICATION_JSON).content("""
 {"campaignNo":"CMP-1","frequencyCap":3,"expectedConversionRate":0.1,"averageOrderValue":1000,"campaignCost":50,"contacts":[
 {"contactNo":"C1","channelAddress":"c1@example.com","consentGranted":true,"suppressed":false,"contactsInWindow":1},
 {"contactNo":"C2","channelAddress":"c2@example.com","consentGranted":false,"suppressed":false,"contactsInWindow":0},
 {"contactNo":"C3","channelAddress":"c3@example.com","consentGranted":true,"suppressed":false,"contactsInWindow":3}]}
 """)).andExpect(status().isOk()).andExpect(jsonPath("$.data.eligible").value(1)).andExpect(jsonPath("$.data.suppressed").value(2)).andExpect(jsonPath("$.data.expectedRevenue").value(100.0)).andExpect(jsonPath("$.data.projectedRoi").value(1.0));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void noEligibleContactBlocksDelivery() throws Exception {mvc.perform(post("/api/enterprise/marketing/delivery-plan").with(httpBasic("operator","operator123")).contentType(MediaType.APPLICATION_JSON).content("""
 {"campaignNo":"CMP-2","frequencyCap":1,"expectedConversionRate":0.1,"averageOrderValue":1000,"campaignCost":50,"contacts":[{"contactNo":"C1","channelAddress":"","consentGranted":false,"suppressed":true,"contactsInWindow":1}]}
 """)).andExpect(status().isOk()).andExpect(jsonPath("$.data.decision").value("BLOCKED"));}
}
