$(function () {
    $("#con_llcs").html("浏览：521322次")
});
$(function () {
    var caseinfo = JSON.stringify({
        "法院ID": "0",
        "案件基本情况段原文": "",
        "附加原文": null,
        "审判程序": "再审",
        "案号": "（2012）刑监字第182-1号",
        "不公开理由": null,
        "法院地市": null,
        "法院省份": null,
        "文本首部段落原文": "",
        "法院区域": null,
        "文书ID": "8252121f-8260-4241-b707-018d52d151ca",
        "案件名称": "宋皓犯受贿罪刑事决定书",
        "法院名称": "最高人民法院",
        "裁判要旨段原文": "",
        "法院区县": null,
        "补正文书": "2",
        "DocContent": "",
        "文书全文类型": null,
        "诉讼记录段原文": "被告人宋皓受贿一案，贵州省高级人民法院2010年4月2日作出（2010）黔高刑二终字第4号刑事判决，维持贵州省六盘水市中级人民法院（2009）黔六中刑三初字第32号刑事判决第一项，即：被告人宋皓犯受贿罪，判处无期徒刑，剥夺政治权利终身，并处没收个人财产人民币10万元；撤销贵州省六盘水市中级人民法院（2009）黔六中刑三初字第32号刑事判决第二项，改判上诉人宋皓受贿所得赃款赃物房屋及现金予以追缴，上缴国库。上述裁判发生法律效力后，宋皓以＆ｌｄｑｕｏ;其与黄某某是合作关系，借款与担保是两人之间约定的特殊合作方式，其参与了公司的日常经营管理活动；原判认定事实不清，适用法律错误＆ｒｄｑｕｏ;为由，向贵州省高级人民法院申诉，该院于2011年12月16日作出（2011）黔高调刑监字第25号通知驳回申诉。宋皓不服向本院申诉，本院于2013年3月14日作出（2012）刑监字第182号指令再审决定，指令贵州省高级人民法院再审本案。贵州省高级人民法院经再审于2013年12月25日作出（2013）黔高刑再终字第2号刑事裁定，驳回申诉，维持该院（2010）黔高刑二终字第4号刑事判决。宋皓不服，再次提出申诉",
        "判决结果段原文": "",
        "文本尾部原文": "",
        "上传日期": "\/Date(1445503696000)\/",
        "案件类型": "1",
        "诉讼参与人信息部分原文": "",
        "文书类型": null,
        "裁判日期": null,
        "结案方式": null,
        "效力层级": null
    });
    $(document).attr("title", "宋皓犯受贿罪刑事决定书");
    $("#tdSource").html("宋皓犯受贿罪刑事决定书 （2012）刑监字第182-1号");
    $("#hidDocID").val("8252121f-8260-4241-b707-018d52d151ca");
    $("#hidCaseName").val("宋皓犯受贿罪刑事决定书");
    $("#hidCaseNumber").val("（2012）刑监字第182-1号");
    $("#hidCaseInfo").val(caseinfo);
    $("#hidCourt").val("最高人民法院");
    $("#hidCaseType").val("1");
    $("#HidCourtID").val("0");
    $("#hidRequireLogin").val("0");
});
$(function () {
    var dirData = {
        Elements: ["RelateInfo", "LegalBase"],
        RelateInfo: [{name: "审理法院", key: "court", value: "最高人民法院"}, {
            name: "案件类型",
            key: "caseType",
            value: "刑事案件"
        }, {name: "案由", key: "reason", value: ""}, {name: "审理程序", key: "trialRound", value: "再审"}, {
            name: "裁判日期",
            key: "trialDate",
            value: "2014-12-29"
        },],
        LegalBase: [{
            法规名称: '《中华人民共和国刑事诉讼法（2012年）》',
            Items: [{
                法条名称: '第二百四十二条',
                法条内容: '    第二百四十二条　当事人及其法定代理人、近亲属的申诉符合下列情形之一的，人民法院应当重新审判：[ly]    （一）有新的证据证明原判决、裁定认定的事实确有错误，可能影响定罪量刑的；[ly]    （二）据以定罪量刑的证据不确实、不充分、依法应当予以排除，或者证明案件事实的主要证据之间存在矛盾的；[ly]    （三）原判决、裁定适用法律确有错误的；[ly]    （四）违反法律规定的诉讼程序，可能影响公正审判的；[ly]    （五）审判人员在审理该案件的时候，有贪污受贿，徇私舞弊，枉法裁判行为的。[ly]'
            }, {
                法条名称: '第二百四十三条第一款',
                法条内容: '    第二百四十三条各级人民法院院长对本院已经发生法律效力的判决和裁定，如果发现在认定事实上或者在适用法律上确有错误，必须提交审判委员会处理。[ly]    最高人民法院对各级人民法院已经发生法律效力的判决和裁定，上级人民法院对下级人民法院已经发生法律效力的判决和裁定，如果发现确有错误，有权提审或者指令下级人民法院再审。[ly]    最高人民检察院对各级人民法院已经发生法律效力的判决和裁定，上级人民检察院对下级人民法院已经发生法律效力的判决和裁定，如果发现确有错误，有权按照审判监督程序向同级人民法院提出抗诉。[ly]    人民检察院抗诉的案件，接受抗诉的人民法院应当组成合议庭重新审理，对于原判决事实不清楚或者证据不足的，可以指令下级人民法院再审。[ly]'
            }, {
                法条名称: '第二百四十四条',
                法条内容: '    第二百四十四条　上级人民法院指令下级人民法院再审的，应当指令原审人民法院以外的下级人民法院审理；由原审人民法院审理更为适宜的，也可以指令原审人民法院审理。[ly]'
            }]
        }]
    };
    if ($("#divTool_Summary").length > 0) {
        $("#divTool_Summary").ContentSummary({data: dirData});
    }
});
$(function () {
    var jsonHtmlData = "{\"Title\":\"宋皓犯受贿罪刑事决定书\",\"PubDate\":\"2015-10-22\",\"Html\":\"<div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'><p></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'><title></title></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'></p></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'><tableborder=”0”cellpadding=”0”cellspacing=”0”xmlns=”http://www.w3.org/1999/xhtml”></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'><tbody></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'><tr></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'><tdwidth=”25”></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'><p></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'></p></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'></td></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'></tr></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'></tbody></div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'></table></div><a type='dir' name='WBSB'></a><div style='TEXT-ALIGN: center; LINE-HEIGHT: 25pt; MARGIN: 0.5pt 0cm; FONT-FAMILY: 宋体; FONT-SIZE: 22pt;'>中华人民共和国最高人民法院</div><div style='TEXT-ALIGN: center; LINE-HEIGHT: 30pt; MARGIN: 0.5pt 0cm; FONT-FAMILY: 仿宋; FONT-SIZE: 26pt;'>再 审 决 定 书</div><div style='TEXT-ALIGN: right; LINE-HEIGHT: 30pt; MARGIN: 0.5pt 0cm;  FONT-FAMILY: 仿宋;FONT-SIZE: 16pt; '>（2012）刑监字第182-1号</div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'>被告人宋皓受贿一案，贵州省高级人民法院2010年4月2日作出（2010）黔高刑二终字第4号刑事判决，维持贵州省六盘水市中级人民法院（2009）黔六中刑三初字第32号刑事判决第一项，即：被告人宋皓犯受贿罪，判处无期徒刑，剥夺政治权利终身，并处没收个人财产人民币10万元；撤销贵州省六盘水市中级人民法院（2009）黔六中刑三初字第32号刑事判决第二项，改判上诉人宋皓受贿所得赃款赃物房屋及现金予以追缴，上缴国库。上述裁判发生法律效力后，宋皓以“其与黄某某是合作关系，借款与担保是两人之间约定的特殊合作方式，其参与了公司的日常经营管理活动；原判认定事实不清，适用法律错误”为由，向贵州省高级人民法院申诉，该院于2011年12月16日作出（2011）黔高调刑监字第25号通知驳回申诉。宋皓不服向本院申诉，本院于2013年3月14日作出（2012）刑监字第182号指令再审决定，指令贵州省高级人民法院再审本案。贵州省高级人民法院经再审于2013年12月25日作出（2013）黔高刑再终字第2号刑事裁定，驳回申诉，维持该院（2010）黔高刑二终字第4号刑事判决。宋皓不服，再次提出申诉。</div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'>本院经审查认为，宋皓通过个人借款、协调有业务关系及无业务关联的房地产开发公司借款及帮助申请贷款等多种途径为贵州新世纪集团房地产开发有限公司开发“世纪佳苑”、“世纪雅苑”两房地产项目提供启动资金、项目运营资金，并承担资金风险。原判认为宋皓没有实际出资，而是利用职务便利为请托人黄某某谋取利益，以合作投资名义收取“干股”的理由不充分。且宋皓的部分行为与其职务无关，原判未予考虑。综上，原判认定宋皓犯受贿罪的部分事实不清，证据不足。宋皓的申诉符合《中华人民共和国刑事诉讼法》第二百四十二条第（二）项、第（三）项规定的应当重新审判条件。据此，依照《中华人民共和国刑事诉讼法》第二百四十三条第二款、二百四十四条的规定，决定如下：</div><a type='dir' name='PJJG'></a><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'>一、指令重庆市高级人民法院对本案进行再审。</div><div style='LINE-HEIGHT: 25pt;TEXT-ALIGN:justify;TEXT-JUSTIFY:inter-ideograph; TEXT-INDENT: 30pt; MARGIN: 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'>二、再审期间，不停止原判决的执行。</div><a type='dir' name='WBWB'></a><br/><div style='TEXT-ALIGN: right; LINE-HEIGHT: 25pt; MARGIN: 0.5pt 72pt 0.5pt 0cm;FONT-FAMILY: 仿宋; FONT-SIZE: 16pt;'>二〇一四年十二月二十九日</div>\"}";
    var jsonData = eval("(" + jsonHtmlData + ")");
    $("#contentTitle").html(jsonData.Title);
    $("#tdFBRQ").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布日期：" + jsonData.PubDate);
    var jsonHtml = jsonData.Html.replace(/01lydyh01/g, "\'");
    $("#DivContent").html(jsonHtml);

    //初始化全文插件
    Content.Content.InitPlugins();
    //全文关键字标红
    Content.Content.KeyWordMarkRed();
});