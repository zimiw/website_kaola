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
					var key = typeId + '_' + menuArr[i].id;
					var temp = {};
					temp.typeId = typeId;
					temp.id = menuArr[i].id;
					temp.name = menuArr[i].name;
					temp.price = menuArr[i].price;

					$scope.menus[key] = temp;
				}
			}
		};

		//菜单的一个对象形式的拷贝，便于读取
		$scope.menus = {
			'100001_1001': {
				typeId: 100001,
				id: 1001,
				name: '法拉利',
				price: 450
			},
			'100001_1002': {
				typeId: 100001,
				id: 1002,
				name: '兰博基尼',
				price: 580
			},
			'100001_1003': {
				typeId: 100001,
				id: 1003,
				name: '兰博基尼',
				price: 680
			},
			'100001_1004': {
				typeId: 100001,
				id: 1004,
				name: '兰博基尼',
				price: 780
			},
			'100001_1011': {
				typeId: 100001,
				id: 1011,
				name: '法拉利',
				price: 450
			},
			'100001_1012': {
				typeId: 100001,
				id: 1012,
				name: '兰博基尼',
				price: 580
			},
			'100001_1013': {
				typeId: 100001,
				id: 1013,
				name: '兰博基尼',
				price: 680
			},
			'100001_1014': {
				typeId: 100001,
				id: 1014,
				name: '兰博基尼',
				price: 780
			},
			'100001_1021': {
				typeId: 100001,
				id: 1021,
				name: '法拉利',
				price: 450
			},
			'100001_1022': {
				typeId: 100001,
				id: 1022,
				name: '兰博基尼',
				price: 580
			},
			'100001_1023': {
				typeId: 100001,
				id: 1023,
				name: '兰博基尼',
				price: 680
			},
			'100001_1024': {
				typeId: 100001,
				id: 1024,
				name: '兰博基尼',
				price: 780
			}
		};

		/**
		 * 购物车的一个备份，方便读取
		 */
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
					price : 450,
					count : 1
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

				size: size, //种类数

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
		$scope.addToOrder = function(id, typeId) {

			var innerId = typeId + '_' + id;
			//数字加1
			var span = $('#span_' + innerId);
			span.html(parseInt(span.html(), 10) + 1);

			//背景颜色变深
			$scope.cart.addItem(innerId);

		};

		/**
		 *  点击取消的操作
		 * @param {Object} dom
		 */
		$scope.reduceOrder = function(id, typeId) {

			var innerId = typeId + '_' + id;
			//数字减1
			var span = $('#span_' + innerId);
			var count = parseInt(span.html(), 10);
			if (count >= 1) {
				span.html(count - 1);
				$scope.cart.removeItem(innerId);
			}
			//如果数量为零，改变背景色
		};

		//查看已点页面的加一份
		$scope.addOne = function(id, typeId) {
			var innerId = typeId + '_' + id;
			$scope.cart.addItem(innerId);
			$scope.hasOrdered.orders = $scope.cart.getHasOrdered();
			$scope.hasOrdered.sum = $scope.cart.getTotalMoney();
			//数字加1
			var span = $('#span_' + innerId);
			span.html(parseInt(span.html(), 10) + 1);
		};

		//查看已点页面的减一份
		$scope.reduceOne = function(id, typeId) {
			var innerId = typeId + '_' + id;
			$scope.cart.removeItem(innerId);
			$scope.hasOrdered.orders = $scope.cart.getHasOrdered();
			$scope.hasOrdered.sum = $scope.cart.getTotalMoney();
			//数字减1
			var span = $('#span_' + innerId);
			var count = parseInt(span.html(), 10);
			if (count >= 1) {
				span.html(count - 1);
			}
		};
		
		/**
		 * get tabs data from database
		 */
		$scope.tabs = [{
			name: 'home',
			'class': 'active',
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
				price: '430',
				imgUrl: 'img/1.jpg',
				monthCount: 30,
				id: 1003
			}, {
				name: '法拉利',
				price: '430',
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
		
		//测试是否可以本地排序
		$scope.range = function(flag){
			if(!flag){
				$scope.tabs[0].content = [{
				name: '法拉利',
				price: '580',
				imgUrl: 'img/2.jpg',
				monthCount: 30,
				id: 1001
			}, {
				name: '兰博基尼',
				price: '580',
				imgUrl: 'img/1.jpg',
				monthCount: 30,
				id: 1002
			}, {
				name: '法拉利',
				price: '430',
				imgUrl: 'img/1.jpg',
				monthCount: 30,
				id: 1003
			}, {
				name: '法拉利',
				price: '430',
				imgUrl: 'img/1.jpg',
				monthCount: 30,
				id: 1004
			}];
			}
		};
		/**
		 * 显示菜单内容
		 * @param {Object} typeId
		 */
		$scope.showMenu = function(typeId) {

			var current = $("#" + typeId);
			var index = this.$index;
			//current.addClass('active');
			if (current.children().length < 1) {
				
				$.ajax({
					url : "",
				});
				//此处应该是ajax获取后台数据
				$scope.tabs[index].content = [{
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
					price: '430',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1013
				}, {
					name: '法拉利',
					price: '430',
					imgUrl: 'img/1.jpg',
					monthCount: 30,
					id: 1014
				}];

				$scope.pushMenu($scope.tabs[index].content, typeId);

			}
		};
		$scope.hideMenu = function(){
			$('#menu_ordered').hide();
		}
	}
]);