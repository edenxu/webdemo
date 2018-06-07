jsPlumb.ready(function() {
	jsPlumb.makeSource($('.item'), {
		connector : 'StateMachine'
	});
	jsPlumb.makeTarget($('.item'), {
		anchor : 'Continuous'
	});
});