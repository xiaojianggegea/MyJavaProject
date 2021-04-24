(function() {
	var bannerNavUl = document.getElementById('banner-nav-ul');
	var bannerNav = document.getElementById('banner-box-nav');
	var menus = document.querySelectorAll('.banner-box-article .banner-box-text');
	var bannerLis = document.querySelectorAll('#banner-nav-ul li');

	// 事件委托
	bannerNavUl.onmouseover = function(e) {
		if(e.target.tagName.toLowerCase() == 'li') {
			// 得到li元素的data-t属性
			var t = e.target.getAttribute('data-t');
			// 让所有的li都去掉appear类名
			for(var i = 0; i < bannerLis.length; i++) {
				bannerLis[i].className = bannerLis[i].getAttribute('data-t');
			}
			// 当前碰到的这个li加appear类
			e.target.className += ' appear';
			// 寻找匹配的menu
			var themenu = document.querySelector('.banner-box-article .banner-box-text[data-t=' + t + ']');
			//让所有的盒子都去掉appear类名
			for(var i = 0; i < menus.length; i++) {
				menus[i].className = 'banner-box-text';
			}
			// 匹配的这项加上appear类名
			themenu.className = 'banner-box-text appear';
		}
	}

	// 当鼠标离开大盒子的时候，菜单要关闭
	bannerNav.onmouseleave = function() {
		for(var i = 0; i < bannerLis.length; i++) {
			bannerLis[i].className = bannerLis[i].getAttribute('data-t');
			menus[i].className = 'banner-box-text';
		}
	}
})();