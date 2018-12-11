package com.zq.learn.seleniumlearn.downloader;

import com.zq.learn.seleniumlearn.downloader.rule.RequestMathRule;
import org.springframework.util.Assert;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 组合下载器
 *
 * @author qun.zheng
 * @create 2018/12/11
 **/
public class ComposeDownloader implements Downloader{

    private Map<RequestMathRule, Downloader> downloaderMap = new HashMap<>();
    private Downloader defaultDownloader = new HttpClientDownloader();

    @Override
    public Page download(Request request, Task task) {
        Iterator<Entry<RequestMathRule, Downloader>> iterator = downloaderMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<RequestMathRule, Downloader> entry = iterator.next();
            if (entry.getKey().match(request)) {
                return entry.getValue().download(request, task);
            }
        }
        return defaultDownloader.download(request,task);
    }

    @Override
    public void setThread(int threadNum) {

    }

    public void setDefaultDownloader(Downloader defaultDownloader) {
        Assert.notNull(defaultDownloader,"default downloader should not be null");
        this.defaultDownloader = defaultDownloader;
    }

    public void addDownloader(Downloader downloader){
        addDownloader(RequestMathRule.All,downloader);
    }

    public void addDownloader(RequestMathRule rule,Downloader downloader){
        downloaderMap.put(rule, downloader);
    }


}
