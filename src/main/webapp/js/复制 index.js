var navTabs = angular.module("navTabs", []);

navTabs.controller("navTabsCtr", ['$scope', '$compile',
	function($scope, $compile) {

		$scope.sum = 0;

		/**
		 * 生成数据结构
		 * @param {Object} menuArr
		 * @param {Object} typeId
		 */
		$scope.pushMenu = function(menuArr, typeId) {

			if ($.isArray(menuArr) && menuArr.length > 0) {

				var i = 0,
					length = menuArr.length;
				for (; i < length; i++) {
					var key = menuArr[i].id;
					var temp = {};
					temp.typeId = typeId;
					temp.id = menuArr[i].id;
					temp.name = menuArr[i].name;
					temp.price = menuArr[i].price;

					$scope.menus[key] = temp;
				}
			}
		};

		$scope.menus = {
			1001: {
				typeId: 1,
				id: 1001,
				name: '法拉利',
				price: 450
			},
			1002: {
				typeId: 1,
				id: 1002,
				name: '兰博基尼',
				price: 580
			},
			1003: {
				typeId: 1,
				id: 1003,
				name: '兰博基尼',
				price: 680
			},
			1004: {
				typeId: 1,
				id: 1004,
				name: '兰博基尼',
				price: 780
			},
			1011: {
				typeId: 1,
				id: 1011,
				name: '法拉利',
				price: 450
			},
			1012: {
				typeId: 1,
				id: 1012,
				name: '兰博基尼',
				price: 580
			},
			1013: {
				typeId: 1,
				id: 1013,
				name: '兰博基尼',
				price: 680
			},
			1014: {
				typeId: 1,
				id: 1014,
				name: '兰博基尼',
				price: 780
			},
			1021: {
				typeId: 1,
				id: 1021,
				name: '法拉利',
				price: 450
			},
			1022: {
				typeId: 1,
				id: 1022,
				name: '兰博基尼',
				price: 580
			},
			1023: {
				typeId: 1,
				id: 1023,
				name: '兰博基尼',
				price: 680
			},
			1024: {
				typeId: 1,
				id: 1024,
				name: '兰博基尼',
				price: 780
			}
		};

		$scope.hasOrdered = {
			orders: [],
			sum: 0
		};
		/**
		 * 购物车
		 */
		$scope.cart = (function() {

			var items = {
				/*11: {
					typeId : 1,
					id : 11,
					name : '法拉利',
					price : 450
				},
				12:{
					typeId : 1,
					id : 12,
					name : '兰博基尼',
					price : 580
				}*/
			};

			var size = 0;

			return {

				size: size,

				getHasOrdered: function() {

					var result = [];
					for (var item in items) {
						if (items.hasOwnProperty(item)) {
							result.push(items[item]);
						}
					}
					return result;
				},

				/**
				 * 获取订单总数
				 */
				getTotalCount: function() {

					if (size <= 0) {
						return 0;
					} else {
						var count = 0;
						for (var item in items) {
							if (items.hasOwnProperty(item)) {
								count += items[item].count;
							}
						}
						return count;
					}
				},

				/**
				 * 总价
				 */
				getTotalMoney: function() {

					if (size <= 0) {
						return 0;
					} else {
						var money = 0;
						for (var item in items) {
							if (items.hasOwnProperty(item)) {
								money += items[item].count * items[item].price;
							}
						}
						return money;
					}
				},

				/**
				 * 加入购物车
				 * @param {Object} item
				 */
				addItem: function(id) {
					if (!items[id]) {
						var temp = {
							'id': $scope.menus[id].id,
							'typeId': $scope.menus[id].typeId,
							'name': $scope.menus[id].name,
							'price': $scope.menus[id].price,
							'count': 1
						}
						items[id] = temp;
						size++;
					} else {
						items[id].count++;
					}
				},
				/**
				 * 从购物车移除
				 * @param {Object} id
				 */
				removeItem: function(id) {
					if (!items[id]) {
						return;
					} else {
						if (items[id].count > 1) {
							items[id].count--;
						} else {
							delete items[id];
							size--;
						}
					}
				},

				/**
				 * 根据购物车的内容，生成后踢啊需要的订单数据格式
				 */
				createOrder: function() {

				}
			}
		})();

		/**
		 * 显示已点
		 */
		$scope.showOrdered = function() {

				$scope.hasOrdered.orders = $scope.cart.getHasOrdered();
				$scope.hasOrdered.sum = $scope.cart.getTotalMoney();
				$('#menu_ordered').show();
			}
			/**
			 * 点击来一份的操作
			 * @param {Object} dom
			 */
		$scope.addToOrder = function(id) {

			//数字加1
			var span = $('#span_' + id);
			span.html(parseInt(span.html(), 10) + 1);

			//背景颜色变深
			$scope.cart.addItem(id);

		};

		$scope.addOne = function(id) {
			$scope.cart.addItem(id);
			$scope.hasOrdered.orders = $scope.cart.getHasOrdered();
			$scope.hasOrdered.sum = $scope.cart.getTotalMoney();
		};

		$scope.reduceOne = function(id) {
			$scope.cart.removeItem(id);
			$scope.hasOrdered.orders = $scope.cart.getHasOrdered();
			$scope.hasOrdered.sum = $scope.cart.getTotalMoney();
		};

		/**
		 *  点击取消的操作
		 * @param {Object} dom
		 */
		$scope.reduceOrder = function(id) {

			//数字减1
			var span = $('#span_' + id);
			var count = parseInt(span.html(), 10);
			if (count >= 1) {
				span.html(count - 1);
				$scope.cart.removeItem(id);
			}
			//如果数量为零，改变背景色

		};

		/**
		 * get tabs data from database
		 */
		$scope.tabs = [{
			name: 'home',
			class: 'active',
			id: '100001',
			content: [{
				name: '法拉利',
				price: '580',
				imgUrl: 'img/1.jpg',
				monthCount: 30,
				id: 1001
			}, {
				name: '兰博基尼',
				price: '580',
				imgUrl: 'img/2.jpg',
				monthCount: 30,
				id: 1002
			}, {
				name: '法拉利',
				price: '430w',
				imgUrl: 'img/1.jpg',
				monthCount: 30,
				id: 1003
			}, {
				name: '法拉利',
				price: '430w',
				imgUrl: 'img/1.jpg',
				monthCount: 30,
				id: 1004
			}]
		}, {
			name: 'profile',
			id: '100002'
		}, {
			name: 'messages',
			id: '100003'
		}, {
			name: 'settings',
			id: '100004'
		}];

		/**
		 * 显示菜单内容
		 * @param {Object} typeId
		 */
		$scope.showMenu = function(typeId) {

			var current = $("#" + typeId);
			//current.addClass('active');
			if (current.children().length < 1) {
				$scope.tabs[1].content = [{
					name: '法拉利',
					price: '580',
					imgUrl: 'img/2.jpg',
					monthCount: 30,
					id: 1011
				}, {
					name: '兰博基尼',
					price: '580',
					imgUrl: 'img/2.jpg',
					monthCount: 30,
					id: 1012
				}, {
					name: '法拉利',
					price: '430w',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1013
				}, {
					name: '法拉利',
					price: '430w',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1014
				}];

				$scope.tabs[2].content = [{
					name: '法拉利rrr',
					price: '580',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1021
				}, {
					name: '兰博基尼fff',
					price: '580',
					imgUrl: 'img/2.jpg',
					monthCount: 30,
					id: 1022
				}, {
					name: '法拉利ddd',
					price: '430w',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1023
				}, {
					name: '法拉利',
					price: '430w',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1024
				}];
			}



			/*var current = $("#" + typeId);
			//current.addClass('active');
			if (current.children().length < 1) {
				$scope.getMenuByType(typeId);
			}*/
		}


		/**
		 * 根据分类id获取菜单并展示在页面
		 * @param {Object} typeId
		 */
		$scope.getMenuByType = function(typeId) {

			/*$.ajax({
		type:"get",
		url:"",
		success: function(result){
			
			$("#id").html(createMenuDom(result.content)); //渲染页面
			$scope.pushMenu(result.content,typeId);  //构建数据结构
		}
	});*/
			var content;
			if (parseInt(typeId, 10) == 100001) {
				content = [{
					name: '法拉利',
					price: '430w',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1011
				}, {
					name: '法拉利',
					price: '430w',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1012
				}, {
					name: '法拉利',
					price: '430w',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1013
				}, {
					name: '法拉利',
					price: '430w',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1014
				}];
			} else {
				content = [{
					name: '兰博基尼',
					price: '430w',
					imgUrl: 'img/2.jpg',
					monthCount: 30,
					id: 1021
				}, {
					name: '兰博基尼',
					price: '430w',
					imgUrl: 'img/2.jpg',
					monthCount: 30,
					id: 1022
				}, {
					name: '兰博基尼',
					price: '430w',
					imgUrl: 'img/2.jpg',
					monthCount: 30,
					id: 1023
				}, {
					name: '兰博基尼',
					price: '430w',
					imgUrl: 'img/2.jpg',
					monthCount: 30,
					id: 1024
				}];
			}

			$("#" + typeId).html($compile($scope.createMenuDom(content))($scope));

			/*angular.element(document).ready(function() {
            angular.bootstrap(document);
            });*/
		};

		$scope.createMenuDom = function(content) {
			var html = '',
				length;
			if (!$.isArray(content) || content.length < 1) {
				return '';
			}
			length = content.length;
			for (var i = 0; i < length; i++) {
				var temp = '<div id="' + 'meun_' + content[i].id + '" class="col-sm-10 col-md-6 col-lg-3"><div class="thumbnail"><div class="img-wrap">' + '<img src="' + content[i].imgUrl + '" alt="farrir" class="img-rounded"></div><div class="caption">' + '<div class="first-line"><b class="title">' + content[i].name + '</b>' + '<a href="javascript:#" role="button" aria-expanded="true"><span class="glyphicon glyphicon-heart-empty"></span></a>' + '<div><em>' + content[i].price + '</em><span>w元</span></div></div><div class="second-line">' + '<div>月售<strong>' + content[i].monthCount + '</strong>份</div></div>' + '<div class="third-line"><a class="btn btn-primary" type="button" ng-click="addToOrder(' + content[i].id + ')">来一份<span class="badge">0</span></a>' + '<a class="btn btn-danger" type="button" onclick="reduceOrder(this)">取消</a></div></div><div class="clearfix"></div></div></div>';
				html += temp;
			}
			/**
			 * 模板内容，留作参考
			 */
			/*<div class="col-sm-10 col-md-6 col-lg-3">
								<div class="thumbnail">
									<div class="img-wrap">
										<img src="{{item.imgUrl}}" alt="farrir" class="img-rounded">
									</div>
									<div class="caption">
										<div class="first-line">
											<b class="title" ng-bind="item.name"></b>
											<a href="javascript:alert('i am in');" role="button" aria-expanded="true"><span class="glyphicon glyphicon-heart-empty"></span></a>
											<div><em ng-bind="item.price"></em><span>w元</span>
											</div>
										</div>
										<div class="second-line">
											<div>已点<strong ng-model="number">4</strong>份</div>
											<div>月售<strong>4</strong>份</div>
										</div>
										<div class="third-line">
											<a class="btn btn-primary" type="button">
												来一份 <span class="badge">0</span>
											</a>
											<a class="btn btn-danger" type="button">
												取消
											</a>
										</div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>*/

			return html;
		}
	}
]);



/**
 * 点击来一份的操作
 * @param {Object} dom
 */
/*function addToOrder(dom) {

	debugger;
	//数字加1
	var span = $(dom).children('span');
	span.html(parseInt(span.html(), 10) + 1);

	//背景颜色变深


	//更新订单数据
	
}*/

/**
 *  点击取消的操作
 * @param {Object} dom
 */
function reduceOrder(dom) {

	//数字减1
	var sibling = $(dom).prev();
	var span = $(sibling).children('span');
	var count = parseInt(span.html(), 10);
	if (count >= 1) {
		span.html(count - 1);
	}
	//如果数量为零，改变背景色

	//更新订单数据
}

function menuClick(index) {
	alert('i am in');
	getCategory(index);
}

function getCategory(index) {
	alert(index);
}