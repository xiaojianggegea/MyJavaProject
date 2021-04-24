/*
 * 轮播图特效
 * 日期：2021年3月7日
 * 姓名：郭怀江
 */
(function() {
	var shuffling_box = document.getElementById('shuffling_box');
	var left_btn = document.getElementById('left_btn');
	var right_btn = document.getElementById('right_btn');
	var circle_ol = document.getElementById('circle_ol');
	var circle_lis = circle_ol.getElementsByTagName('li');
	var banner_box = document.getElementById('banner_box');
	// 克隆第一张li
	var cloning_li = shuffling_box.firstElementChild.cloneNode(true);
	// 上树
	shuffling_box.appendChild(cloning_li);
	// 正在显示广告的序号
	var idx = 0;
	// 节流锁
	var lock = true;
	right_btn.onclick = right_btn_handler;
	// 处理函数
	function right_btn_handler() {
		if(!lock) return;
		// 上锁
		lock = false;
		shuffling_box.style.transition = 'transform 0.5s ease 0s';
		idx++;
		shuffling_box.style.transform = 'translateX(' + -16.66 * idx + '%)';
		// 判断是否为最后一张
		if(idx > 4) {
			setTimeout(function() {
				// 去掉过渡
				shuffling_box.style.transition = 'none';
				// 删除过渡
				shuffling_box.style.transform = 'none';
				idx = 0;
			}, 500);
		}
		// 设置小圆点
		setCircles();
		// 动画结束之后开锁
		setTimeout(function() {
			lock = true;
		}, 500);
	};
	// 左按钮事件
	left_btn.onclick = function() {
			if(!lock) return;
			// 上锁
			lock = false;
			if(idx == 0) {
				shuffling_box.style.transition = 'none';
				shuffling_box.style.transform = 'translateX(' + -16.66 * 5 + '%)';
				idx = 4;
				setTimeout(function() {
					shuffling_box.style.transition = 'transform .5s ease 0s';
					shuffling_box.style.transform = 'translateX(' + -16.66 * 4 + '%)';
				}, 0);
			} else {
				idx--;
				shuffling_box.style.transform = 'translateX(' + -16.66 * idx + '%)';
			}
			// 设置小圆点
			setCircles();
			// 动画结束之后开锁
			setTimeout(function() {
				lock = true;
			}, 500);
		}
		// 设置小圆点在谁身上
	function setCircles() {
		// 遍历，遍历0、1、2、3、4。每遍历一个数字，都要和idx比一下，如果相等，就把这项设置类名为current，否则去掉类名。
		for(var i = 0; i <= 4; i++) {
			if(i == idx % 5) {
				circle_lis[i].className = 'current';
			} else {
				circle_lis[i].className = '';
			}
		}
	}
	// 事件委托，小圆点的监听
	circle_ol.onclick = function(e) {
			if(e.target.tagName.toLowerCase() == 'li') {
				// 得到li身上的data-n属性，就是n
				var n = Number(e.target.getAttribute('data-n'));
				// 改变idx
				idx = n;
				// 拉动
				shuffling_box.style.transform = 'translateX(' + -16.66 * idx + '%)';
				// 调用改变小圆点函数
				setCircles();
			}
		}
		// 定时器，自动轮播
	var timer = setInterval(right_btn_handler, 2000);

	// 鼠标进入，自动轮播暂停
	banner_box.onmouseenter = function() {
		clearInterval(timer);
	}

	// 鼠标离开，自动轮播开始
	banner_box.onmouseleave = function() {
		clearInterval(timer);
		// 设置定时器，这里不要加var，加var就变为局部变量了，就clear不掉了！
		timer = setInterval(right_btn_handler, 2000);
	}
})();