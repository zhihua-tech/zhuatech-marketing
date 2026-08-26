/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.marketing.service;
import jakarta.validation.Valid;import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.math.*;import java.util.*;
@Service public class EnterpriseMarketingService {
 public DeliveryPlan plan(@Valid DeliveryRequest req){
  List<ContactDecision> decisions=new ArrayList<>();int eligible=0;
  for(var contact:req.contacts()){
   List<String> reasons=new ArrayList<>();if(!contact.consentGranted())reasons.add("未取得营销授权");if(contact.suppressed())reasons.add("退订或黑名单");
   if(contact.contactsInWindow()>=req.frequencyCap())reasons.add("达到频控上限");if(contact.channelAddress().isBlank())reasons.add("渠道地址为空");
   boolean allowed=reasons.isEmpty();if(allowed)eligible++;decisions.add(new ContactDecision(contact.contactNo(),allowed,reasons));
  }
  BigDecimal expectedConversions=BigDecimal.valueOf(eligible).multiply(req.expectedConversionRate());
  BigDecimal expectedRevenue=expectedConversions.multiply(req.averageOrderValue());BigDecimal roi=req.campaignCost().signum()==0?BigDecimal.ZERO:expectedRevenue.subtract(req.campaignCost()).divide(req.campaignCost(),4,RoundingMode.HALF_UP);
  return new DeliveryPlan(req.campaignNo(),req.contacts().size(),eligible,req.contacts().size()-eligible,money(expectedConversions),money(expectedRevenue),roi,decisions,eligible==0?"BLOCKED":"READY");
 }
 private BigDecimal money(BigDecimal v){return v.setScale(2,RoundingMode.HALF_UP);}
 public record DeliveryRequest(@NotBlank String campaignNo,@Positive int frequencyCap,@NotNull @DecimalMin("0") @DecimalMax("1") BigDecimal expectedConversionRate,@NotNull @DecimalMin("0") BigDecimal averageOrderValue,@NotNull @DecimalMin("0") BigDecimal campaignCost,@NotEmpty List<@Valid Contact> contacts){}
 public record Contact(@NotBlank String contactNo,@NotNull String channelAddress,boolean consentGranted,boolean suppressed,@PositiveOrZero int contactsInWindow){}
 public record ContactDecision(String contactNo,boolean allowed,List<String> reasons){}
 public record DeliveryPlan(String campaignNo,int audience,int eligible,int suppressed,BigDecimal expectedConversions,BigDecimal expectedRevenue,BigDecimal projectedRoi,List<ContactDecision> decisions,String decision){}
}
