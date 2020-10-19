package com.iskeen.project.crawler.core.processor.XSoft;

import java.util.List;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

/**
 * @ClassName XSoftListPageProcessor
 * @Description: TODO
 * @Author zhouxiangfu
 * @Date 2020/10/10 5:53 下午
 * @Version V1.0
 **/

public class XSoftListPageProcessor implements PageProcessor {

  // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
  private Site site = Site.me().setDomain("www.sxsoft.com");

  @Override
  public void process(Page page) {
// 部分二：定义如何抽取页面信息，并保存下来
    List<String> links = page.getHtml().links().regex("http://www\\.sxsoft\\.com/\\d+").all();
    page.addTargetRequests(links);
    page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
    page.putField("content", page.getHtml().$("div.content").toString());
    page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
  }

  @Override
  public Site getSite() {
    return site;
  }


}