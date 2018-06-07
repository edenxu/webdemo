// 查找数组中某个元素的位置
Array.prototype.indexOf = function(val) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == val) return i;
	}
	return -1;
};

// 从数组中删除指定元素
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		// 要删除数组中的指定位置开始,N个元素
		this.splice(index, 1);
	}
};