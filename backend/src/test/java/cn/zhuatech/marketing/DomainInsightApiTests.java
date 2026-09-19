/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.marketing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@SpringBootTest @AutoConfigureMockMvc
class DomainInsightApiTests {
    @Autowired MockMvc mvc;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void domainInsightProducesAuditableDecision() throws Exception {
        mvc.perform(post("/api/insights/marketing").with(httpBasic("operator","operator123"))
            .contentType(MediaType.APPLICATION_JSON).content("{\"impressions\":10000,\"clicks\":1000,\"leads\":100,\"opportunities\":30,\"wins\":10,\"spend\":50000,\"revenue\":150000}"))
            .andExpect(status().isOk()).andExpect(jsonPath("$.data.decision").value("SCALE"));
    }
}
