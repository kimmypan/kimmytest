#coding=utf-8
import urllib
import re
#获取页面
def getHtml(url):
    page = urllib.urlopen(url)
    html = page.read()
    return html
#获取页面的所有图片
def getImg(html):
    reg = r'src="(.+?\.jpg)" pic_ext' #正则表达式文本
    imgre = re.compile(reg)  #进行编译
    imglist = re.findall(imgre,html) 
    x = 0
    for imgurl in imglist: 
        imgurl = 'http://imgsrc.baidu.com/forum/pic/item/'+imgurl[-44:]  #找到原图的地址规则，赋值获取原图
        urllib.urlretrieve(imgurl,'E:\\pachong\\%s.jpg' % x)
        print 'E:\\pachong\\%s.jpg' % x
        x+=1


html = getHtml("http://tieba.baidu.com/p/2460150866")
getImg(html)
print'yes'