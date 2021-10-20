<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>秀云游 ---- 旅游攻略</title>
    <meta name="keywords" content="机票，酒店，旅游攻略，签证，出国，自由行">
    <meta name="description" content="秀云游有10多年旅游行业经验，为您提供全方位旅游服务">
    <link rel="stylesheet" type="text/css" href="css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <link rel="stylesheet" type="text/css" href="css/index-section-banner.css"/>
    <link rel="stylesheet" type="text/css" href="css/index-section-banner-hot.css"/>
    <link rel="stylesheet" type="text/css" href="css/index-section-local-depth-travel.css"/>
    <link rel="stylesheet" type="text/css" href="css/index-section-features.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/index-header-icon.css"/>
</head>
<body>
<header class="header-box">
    <nav class="nav-box3">
        <div class="center-box3">
            <span class="box3-logo">秀云游</span>
            <a href="" class="box3-find-button">
                <img src="images/icon-find.png">
            </a>
            <input type="text">
        </div>
    </nav>
    <!-- 主导航条 -->
    <nav class="nav-box2">
        <div class="center-box2">
            <ul>
                <li>
                    <a href="index.html">首页</a>
                </li>
                <li>
                    <a href="#tiao">当地玩乐</a>
                </li>
                <li>
                    <a href="https://map.baidu.com/@11559618.74,4284497.52,12z" target="_search">交通导航</a>
                </li>
                <li>
                    <a href="#hot">特色风景</a>
                </li>
                <li>
                    <a href="about-us.html">关于我们</a>
                </li>
            </ul>
            <div class="box1-line"></div>
            <a href="qq.html" class="box1-icon">
                <img src="images/icon-qq.png">
            </a>
            <a href="wb.html" class="box1-icon">
                <img src="images/icon-weibo.png">
            </a>
            <a href="wx.html" class="box1-icon">
                <img src="images/icon-weixin.png">
            </a>

            <a href="login.html" target="_search"><span id="user-text">未登录,点击登录</span></a>
            <div id="login-header-icon"></div>
        </div>
    </nav>
</header>
<section class="banner-box" id="banner_box">
    <ul class="shuffling-box" id="shuffling_box">
        <li><img src="images/banner1.png"></li>
        <li><img src="images/banner2.png"></li>
        <li><img src="images/banner3.png"></li>
        <li><img src="images/banner4.png"></li>
        <li><img src="images/banner5.png"></li>
    </ul>
    <!-- 版心盒子 -->
    <div class="banner-box-center-box">
        <!-- 小圆点 -->
        <ol class="cricles" id="circle_ol">
            <li data-n="0" class="current"></li>
            <li data-n="1"></li>
            <li data-n="2"></li>
            <li data-n="3"></li>
            <li data-n="4"></li>
        </ol>
        <a href="javascript:;" class="left-btn" id="left_btn"></a>
        <a href="javascript:;" class="right-btn" id="right_btn"></a>
        <nav class="banner-box-nav" id="banner-box-nav">
            <ul id="banner-nav-ul">
                <li class="hot-start current" data-t="hot-start">
                    <dl>
                        <dt>热门出发地</dt>
                        <dd>
                            <em>兰州</em>
                            <em>嘉峪关</em>
                            <em>武威</em>
                            <em>天水</em>
                            <em>庆阳</em>
                        </dd>
                    </dl>
                </li>
                <li class="hongkong-taiwan" data-t="hongkong-taiwan">
                    <a href="lanzhou.html">
                        <dl>
                            <dt>兰州</dt>
                            <dd>
                                <em>白塔山</em>
                                <em>省博物馆</em>
                                <em>中山桥</em>
                                <em>黄河母亲</em>
                            </dd>
                        </dl>
                    </a>
                </li>
                <li class="japan-korea" data-t="japan-korea">
                    <a href="jiayuguan.html">
                        <dl>
                            <dt>嘉峪关</dt>
                            <dd>
                                <em>长城</em>
                                <em>黑山湖</em>
                                <em>柔远楼</em>
                                <em>将军府</em>
                            </dd>
                        </dl>
                    </a>
                </li>
                <li class="southeast-asia" data-t="southeast-asia">
                    <a href="detailsPage.html">
                        <dl>
                            <dt>武威</dt>
                            <dd>
                                <em>天梯石窟</em>
                                <em>雷台汉墓</em>
                                <em>天堂寺</em>
                                <em>马牙雪山</em>
                            </dd>
                        </dl>
                    </a>
                </li>
                <li class="european-anericas" data-t="european-anericas">
                    <a href="tianshui.html">
                        <dl>
                            <dt>天水</dt>
                            <dd>
                                <em>伏羲庙</em>
                                <em>水帘洞</em>
                                <em>李广墓</em>
                                <em>仙人崖</em>
                            </dd>
                        </dl>
                    </a>
                </li>
                <li class="middle-east" data-t="middle-east">
                    <a href="qinyang.html">
                        <dl>
                            <dt>庆阳</dt>
                            <dd>
                                <em>周祖陵</em>
                                <em>南梁革命纪念馆</em>
                                <em>北石窟</em>
                            </dd>
                        </dl>
                    </a>
                </li>
            </ul>
            <!-- banner-nav 内容 -->
            <article class="banner-box-article">
                <!-- 热门出发地内容 -->
                <div class="banner-box-text" data-t="hot-start">
                    <dl>
                        <dt>兰州</dt>
                        <dd>
                            <p>兰州自秦朝设县以来已有2200多年的建城史，自古就是“联络四域、襟带万里”的交通枢纽和军事要塞，以“金城汤池”之意命名金城，素有“黄河明珠”的美誉。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>嘉峪关</dt>
                        <dd>
                            <p>嘉峪关是世界文化遗产，国家AAAAA级旅游景区，全国重点文物保护单位，全国爱国主义教育示范基地。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>武威</dt>
                        <dd>
                            <p>
                                武威历史悠久，早在四、五千年前，就有戎、崔、月氏、乌孙等北方民族聚族而居。自汉武帝派骠骑将军霍去病远征河西，击败匈奴，彰显大汉帝国的“武功军威”命名武威，已有近2200多年的历史。
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>天水，庆阳......</dt>
                    </dl>
                </div>
                <div class="banner-box-text" data-t="hongkong-taiwan">
                    <dl>
                        <dt>白塔山</dt>
                        <dd>
                            <p>白塔山位于兰州市黄河北岸，海拔一千七百多米，山势起伏，有“拱抱金城”之雄姿。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>省博物馆</dt>
                        <dd>
                            <p>馆内收藏有各类新石器时代彩陶和石窟艺术珍宝，展示出甘肃历时7000-3000多年彩陶发展体系。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>中山桥</dt>
                        <dd>
                            <p>兰州历来是东西交通要冲，中原与西域往来的必经之途，穿城而过的黄河则是横亘在兰州这一交通枢纽之上的障碍，民间曾有“隔河如隔天，渡河如渡鬼门关”的歌谣。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>黄河母亲</dt>
                        <dd>
                            <p>“黄河母亲”雕塑，位于兰州市黄河南岸的滨河路中段、小西湖公园北侧，是目前全国诸多表现中华民族的母亲河——黄河的雕塑艺术品中最漂亮的一尊。</p>
                        </dd>
                    </dl>
                </div>
                <div class="banner-box-text" data-t="japan-korea">
                    <dl>
                        <dt>嘉峪关</dt>
                        <dd>
                            <p>位于甘肃省嘉峪关市境内。距离甘肃省嘉峪关市区约11公里，距离嘉峪关关城约7公里，因筑于约四十五度的山脊之上，形似凌空倒挂，因而得名“悬臂长城”。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>黑山湖</dt>
                        <dd>
                            <p>西靠黑山，北临悬壁长城，嘉峪关市西北，遇见黑山湖水库。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>柔远楼</dt>
                        <dd>
                            <p>明王朝对边陲（关外）各游牧民族实行“怀柔”政策，安抚边远地区，以实现长治久安的治国方略。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>将军府</dt>
                        <dd>
                            <p>位于嘉峪关内城中, 也称游击衙门，初建于明隆庆年间，后来成为明清两代镇守嘉峪关的游击将军处理军机政务的场所。</p>
                        </dd>
                    </dl>
                </div>
                <div class="banner-box-text" data-t="southeast-asia">
                    <dl>
                        <dt>天梯石窟</dt>
                        <dd>
                            <p>我国开凿最早的石窟之一，也是我国早期石窟艺术的代表，是云冈石窟、龙门石窟的源头，在我国佛教史上具有重要地位，在学术界有着“石窟鼻祖”之称。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>雷台汉墓</dt>
                        <dd>
                            <p>甘肃省武威市凉州区北关中路，约建于东汉晚期。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>天堂寺</dt>
                        <dd>
                            <p>天祝十四寺院之首，其前身为唐宪宗（806-- 822）年间所建藏族苯教寺院，鼎盛时僧侣达千余人，素有“天堂八百僧”之称</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>马牙雪山</dt>
                        <dd>
                            <p>马牙雪山因形似马牙，终年积雪而得名。古人有诗赞曰：“马齿天成银作骨，龙鳞日积玉为胎”。常年有雪，冬季比较严寒，夏天气候多变，山上打雷，顷刻间就有鹅毛般的大雪倾泻而下，特别刺激。
                            </p>
                        </dd>
                    </dl>
                </div>
                <div class="banner-box-text" data-t="european-anericas">
                    <dl>
                        <dt>伏羲庙</dt>
                        <dd>
                            <p>目前我国规模最宏大、保存最完整的纪念上古"三皇"之一伏羲氏的明代建筑群，中国西北地区著名古建筑群之一，原名太昊宫，俗称人宗庙，地址位于甘肃省天水市秦州区西关伏羲路。
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>水帘洞</dt>
                        <dd>
                            <p>武山水帘洞位于甘肃省天水市武山县城东北约25公里的钟楼山峡谷内，谷中"群峰叠嶂觅无路，乱石开径别有天。谷涧溪水潺潺，景色幽静宜人。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>李广墓</dt>
                        <dd>
                            <p>此墓是李广的“衣冠冢”。葬宝剑衣物。墓前原有石兽石马，造型生动，故得石马坪之名。</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>仙人崖</dt>
                        <dd>
                            <p>仙人崖山巍、水秀、崖俊、林密，自然风景秀丽；人文景观仅次于麦积山景区，寺观、庙宇、窟龛多建于高耸的峰顶或凸凹的飞崖间。</p>
                        </dd>
                    </dl>
                </div>
                <div class="banner-box-text" data-t="middle-east">
                    <dl>
                        <dt>周祖陵</dt>
                        <dd>
                            <p>周祖陵森林公园位于甘肃省庆阳市庆城县城东山，国家AAAA级旅游景区，周人先祖不窋失农官之后，西徙定居今之庆阳庆城一带，从事农业耕作，在陇东庆阳一带创建了华夏文明的农耕文化。
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>南梁革命纪念馆</dt>
                        <dd>
                            <p>南梁革命纪念馆，坐落在甘肃省庆阳市华池县南梁镇荔园堡，为了纪念二十世纪三十年代初刘志丹、谢子长、习仲勋等无产阶级革命家开展游击活动、在此建立陕甘边区苏维埃政府而修建
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>北石窟</dt>
                        <dd>
                            <p>北石窟寺为全国重点文物保护单位，甘肃省庆阳市西峰区西南25公里处，蒲河和茹河交汇之东岸的覆锺山下，距市区25千米，海拔1083米，现存大小窟龛307个，石雕造像2126
                                尊，为甘肃省四大石窟之一。</p>
                        </dd>
                    </dl>
                </div>
            </article>
        </nav>
    </div>
</section>
<!-- 热门广告 -->
<section class="banner-hot-box clearfix">
    <div class="center-box4">
        <ul>
            <li>
                <a href="dunhuang.html"><img src="images/small05.png"></a>
            </li>
            <li>
                <a href="dunhuang.html"><img src="images/small06.png"></a>
            </li>
            <li>
                <a href="dunhuang.html"><img src="images/small07.png"></a>
            </li>
            <li>
                <a href="dunhuang.html"><img src="images/small08.jpg"></a>
            </li>
        </ul>
    </div>
</section>
<!-- 当地玩乐 -->
<section class="local-box content-part" id="tiao">
    <div class="center-box6">
        <div class="local-box-header clearfix">
            <h2>当地玩乐</h2>
            <em>像当地人一样，体验本土的吃喝玩乐</em>
            <nav class="local-box-nav">
                <ul id="local_nav">
                    <li class="text-color" id="text">
                        <a href="javascript:;" id="link">甘肃</a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="local-box-img">
            <div class="place-big-box">
                <div class="big-box-img">
                    <img src="images/local1.jpg">
                    <div class="local-box-text">
                        <p class="local-box-text1">[鸣沙山月牙泉]自汉代以来，月牙泉从未干涸过，堪称世界奇观。</p>
                        <p class="local-box-text2">沙漠骆驼</p>
                        <p class="local-box-text3">99</p>
                        <p class="local-box-text4">元起</p>
                    </div>
                </div>
                <a href="gannan.html">
                    <div class="place-box">
                        <div class="place-box-img">
                            <img src="images/local2.jpg">
                        </div>
                        <p>[甘南] 有着深厚的历史文化背景和民俗风情之地当地的藏族文化堪称一绝。</p>
                    </div>
                </a>
            </div>
            <div class="place-big-box">
                <a href="gannan.html">
                    <div class="place-box">
                        <div class="place-box-img">
                            <img src="images/local3.jpg">
                        </div>
                        <p>[黄河石林] 由桔黄色砂砾石构成的石林，在黄河水的映衬之下显得鳞次栉比，气势磅礴，其也被称作“中华自然奇观”。</p>
                    </div>
                </a>
                <a href="gannan.html">
                    <div class="place-box">
                        <div class="place-box-img">
                            <img src="images/local5.jpg">
                        </div>
                        <p>[黄河铁桥] 有着“天下黄河第一桥”的美称，是兰州市的标志性建筑之一。</p>
                    </div>
                </a>
                <a href="gannan.html">
                    <div class="place-box">
                        <div class="place-box-img">
                            <img src="images/local4.jpg">
                        </div>
                        <p>西汉酒泉胜迹 | 河西走廊唯一一座保存完整的汉式园林。</p>
                    </div>
                </a>
            </div>
            <div class="place-big-box">
                <a href="gannan.html">
                    <div class="place-box">
                        <div class="place-box-img">
                            <img src="images/local6.png">
                        </div>
                        <p>[崆峒山] 道教第一山，相传黄帝就曾到此山向在此修行的广成子问道。山间包含八台九宫四十二院七十二洞天。</p>
                    </div>
                </a>
                <div class="local-box-more">
                    <p>查看更多</p>
                    <p>当地玩乐产品</p>
                    <a href="">
                        <img src="images/right-arrow.png">
                    </a>
                    <ul>
                        <li>交通导航</li>
                        <li>特色体验</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- 小导航栏 -->
<!-- 特色当地体验 -->
<section class="features-box content-part" id="hot">
    <div class="center-box7">
        <h2>特色当地体验</h2>
        <div class="features-box-img-box">
            <div class="features-img-box">
                <a href="dunhuang.html">
                    <div class="features-box-img">
                        <img src="images/features5.png">
                    </div>
                </a>

                <p>丝绸之路国际文化博览会- 无需换票扫码入展</p>
                <ul>
                    <li><img src="images/star-icon.png"></li>
                    <li>4.8</li>
                    <li>（92833评价)2334.69k 人参加过</li>
                </ul>
            </div>
        </div>
        <div class="features-box-img-box">
            <div class="features-img-box">
                <a href="huyanglin.html">
                    <div class="features-box-img">
                        <img src="images/features2.jpg">
                    </div>
                </a>
                <p>金塔胡杨林- 邂逅秋天的童话</p>
                <ul>
                    <li><img src="images/star-icon.png"></li>
                    <li>4.6</li>
                    <li>（440条评价)900K+ 人参加过</li>
                </ul>
            </div>
        </div>
        <div class="features-box-img-box">
            <div class="features-img-box">
                <a href="silu.html">
                    <div class="features-box-img">
                        <img src="images/features1.png">
                    </div>
                </a>
                <p>丝路自驾游 - 感受古商路之繁华</p>
                <ul>
                    <li><img src="images/star-icon.png"></li>
                    <li>4.6</li>
                    <li>（4,293条评价)50K+ 人参加过</li>
                </ul>
            </div>
        </div>
        <div class="features-box-img-box">
            <div class="features-img-box">
                <a href="jiuse.html">
                    <div class="features-box-img">
                        <img src="images/features3.png">；
                    </div>
                </a>
                <p>九色甘南- 顺着黄河去领略这被旅行者长期忽略的独特藏域</p>
                <ul>
                    <li><img src="images/star-icon.png"></li>
                    <li>4.6</li>
                    <li>（2,104条评价)20K+ 人参加过</li>
                </ul>
            </div>
        </div>
    </div>
</section>

<footer class="footer1-box">
    <div class="center-box8">
        <ul>

            <li>
                <a href="">当地玩乐</a>
            </li>
            <em>|</em>
            <li>
                <a href="">交通导航</a>
            </li>
            <em>|</em>
            <li>
                <a href="">新鲜甩尾</a>
            </li>
            <em>|</em>
            <li>
                <a href="">深度旅行</a>
            </li>
        </ul>
        <div class="close-service-box">
            <dl class="close-service-box-text1">
                <dt>贴心服务</dt>
                <dd>我们收集秀云游者的真实诉求，找寻特色旅行目的地，让秀云游者放心出行</dd>
            </dl>
        </div>
        <div class="close-service-box">
            <dl class="close-service-box-text2">
                <dt>层层筛选</dt>
                <dd>对旅游产品供应商严格筛选，资质层层把关为秀云游者挑选符合需求的旅行产品</dd>
            </dl>
        </div>
        <div class="close-service-box">
            <dl class="close-service-box-text3">
                <dt>安心陪护</dt>
                <dd>对秀云游者的购买进行跟踪服务以及质量监控，生效投诉先行赔付，出现问题及时解决</dd>
            </dl>
        </div>
    </div>

</footer>
<footer class="footer2-box">
    <div class="center-box9">
        <div class="footer2-header clearfix">
            <h2>秀云游</h2>
            <p class="footer2-text">从一次暖心的服务、一次层层筛选、一次安心陪护让我们带你探索这个世界</p>
        </div>
        <div class="footer2-links clearfix">
            <ul>
                <li>
                    <a href="">关于秀云游商城</a>
                </li>
                <li>
                    <a href="">服务与隐私</a>
                </li>
                <li>
                    <a href="">联系我们</a>
                </li>
                <li>
                    <a href="">旅游度假资质</a>
                </li>
                <li>
                    <a href="">营业执照</a>
                </li>
                <li>
                    <a href="">投诉建议</a>
                </li>
            </ul>
        </div>
        <div class="footer2-copyrights">
            &copy; 2020 imooc.com  京ICP备 12003892号-11 京公网安备11010802030151号
            <a href="">营业执照</a>
        </div>
    </div>
</footer>
<!-- 返回顶部 -->
<a href="javascript:;" class="backtotop" id="backtotop">
    <img src="images/return-top-icon.png"> 返回顶部
</a>
<!-- banner轮播图js-->
<script src="js/index-section-banner.js"></script>
<!-- 菜单动画 -->
<script src="js/index-banner-menu.js"></script>
<!-- 返回顶部 -->
<script src="js/index-backtotop.js"></script>
</body>
</html>
