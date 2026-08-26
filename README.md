# ZhuaTech Marketing｜知华科技营销自动化与客户旅程系统

        > 把人群、活动、触达、线索和转化放进统一营销工作台。

        [![Java 21](https://img.shields.io/badge/Java-21-315a70)](backend/pom.xml) [![Vue 3](https://img.shields.io/badge/Vue-3-42b883)](frontend/package.json) [![MySQL 8](https://img.shields.io/badge/MySQL-8-4479a1)](compose.yaml) [![个人非商用](https://img.shields.io/badge/license-personal%20non--commercial-b47b3a)](LICENSE)

        ZhuaTech Marketing 是知华科技（上海如静知华信息科技有限公司）发布的前后端分离企业应用社区源码版，面向营销活动、客户分群、自动化旅程、渠道触达、线索培育和归因分析。官网：[https://www.zhuatech.cn/](https://www.zhuatech.cn/)。

        ## 业务闭环

        ```text
        确认计划 → 上线运行 → 暂停活动 → 结束复盘
        ```

        ## 主要模块

        | 模块 | 已实现能力 |
        | --- | --- |
        | 营销活动 | 制定目标、预算、渠道和内容计划 |
| 客户分群 | 按属性、行为和交易条件管理人群 |
| 自动化旅程 | 编排触发、等待、分支和多渠道动作 |
| 线索与归因 | 跟踪线索评分、转化和活动贡献 |
        | 运营总览 | 状态结构、模块负荷、金额指标、风险关注和最近业务 |
        | 领域计算 | 营销漏斗与ROI分析，提供可解释计算结果和处理建议 |
| 操作审计 | 创建、修改、删除、流程动作和设置变更均保留操作人及时间 |
        | 系统设置 | 核心业务参数持久化，管理员权限隔离 |

        管理端支持业务记录查询、新增、修改、删除、状态流转、越级操作拦截和审计追踪；响应式界面可在电脑和移动浏览器使用。演示数据全部为虚构数据。

        ## 技术架构

        - 后端：Java 21、Spring Boot 4、Spring Security、Spring Data JPA、MySQL 8
        - 前端：Vue 3、Vite，管理端与业务工作台响应式布局
        - 测试：H2 隔离数据库、MockMvc 接口与权限集成测试
        - 部署：Docker Compose、Nginx 反向代理、健康检查和环境变量
        - Java 工程包：`cn.zhuatech.marketing`

        ## 快速启动

        ```bash
        cp .env.example .env
        docker compose up --build
        ```

        浏览器打开 `http://localhost:8109`。演示账号：`admin / admin123`、`operator / operator123`。默认密码只能用于本地演示，上线前必须修改。

        本地开发：

        ```bash
        cd backend && mvn test
        cd ../frontend && npm install && npm run build
        ```

        更多资料参见 [API 文档](docs/API.md)、[架构说明](docs/ARCHITECTURE.md)、[安全政策](SECURITY.md)和[贡献指南](CONTRIBUTING.md)。

        ## 使用范围

        本工程仅允许个人非商业性的学习、研究和技术交流，**不得商用**。商用、二次销售、SaaS 服务、企业部署及深度定制须取得上海如静知华信息科技有限公司书面授权。

        商业授权、企业信息化、AI 转型、软件外包、项目实施和深度定制请访问[知华科技官网](https://www.zhuatech.cn/)，或扫描微信二维码咨询。

        <p align="center"><img src="docs/images/zhuatech-wechat-consulting.png" alt="知华科技微信咨询二维码一" width="230"><img src="docs/images/zhuatech-wechat-consulting-2.png" alt="知华科技微信咨询二维码二" width="230"></p>

        SEO 关键词：营销自动化、客户旅程、客户分群、线索培育、营销归因、知华科技、上海软件开发、企业信息化、软件项目外包。
