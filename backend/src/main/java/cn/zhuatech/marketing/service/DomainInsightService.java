/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.marketing.service;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.*;
import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class DomainInsightService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Map<String,Object> analyze(InsightRequest req){
        Map<String,Object> result=new LinkedHashMap<>();
        BigDecimal ctr=rate(req.clicks(),req.impressions());BigDecimal leadRate=rate(req.leads(),req.clicks());BigDecimal winRate=rate(req.wins(),req.opportunities());
BigDecimal roi=req.spend().signum()==0?BigDecimal.ZERO:req.revenue().subtract(req.spend()).divide(req.spend(),4,RoundingMode.HALF_UP);
result.put("clickThroughRate",ctr);result.put("leadRate",leadRate);result.put("winRate",winRate);result.put("roi",roi);result.put("decision",roi.compareTo(BigDecimal.ONE)>=0?"SCALE":roi.signum()>=0?"OPTIMIZE":"STOP_AND_REVIEW");
        return result;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    private BigDecimal rate(long numerator,long denominator){return denominator==0?BigDecimal.ZERO:BigDecimal.valueOf(numerator).multiply(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(denominator),2,RoundingMode.HALF_UP);}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record InsightRequest(@PositiveOrZero int impressions, @PositiveOrZero int clicks, @PositiveOrZero int leads, @PositiveOrZero int opportunities, @PositiveOrZero int wins, @DecimalMin("0.0") BigDecimal spend, @DecimalMin("0.0") BigDecimal revenue){}
}
