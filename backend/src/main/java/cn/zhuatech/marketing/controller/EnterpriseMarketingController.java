/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.marketing.controller;import cn.zhuatech.marketing.common.ApiResponse;import cn.zhuatech.marketing.service.EnterpriseMarketingService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/enterprise/marketing") public class EnterpriseMarketingController {private final EnterpriseMarketingService service;/**
                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                           */
public EnterpriseMarketingController(EnterpriseMarketingService service){this.service=service;}/**
                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                          */
@PostMapping("/delivery-plan") ApiResponse<EnterpriseMarketingService.DeliveryPlan> plan(@Valid @RequestBody EnterpriseMarketingService.DeliveryRequest request){return ApiResponse.ok(service.plan(request));}}
