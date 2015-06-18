$(document).ready(function() {
    $(".timer").TimeCircles({ start: false, count_past_zero: false });


    $(".start").one("click", startTimer);

    $(".reset").click(function(){
        var timerInput = $("#timerInput").val();
        $(".timer").data("timer", timerInput).TimeCircles().rebuild().restart();
    });

    $(".record").click(function() {
        recordDuration();
    });

    function startTimer() {
        $(this).html("Stop").addClass("stop").removeClass("start");
        var timerInput = $("#timerInput").val();
        $(".timer").data("timer", timerInput).TimeCircles().start();
        $(this).one("click", stopTimer)
    }

    function stopTimer() {
        $(this).html("Start").addClass("start").removeClass("stop");
        $(".timer").TimeCircles().stop();
        $(this).one("click", startTimer);
    }

    function recordDuration() {
        var totalTime = $("#timerInput").val();
        var timeLeft = $(".timer").TimeCircles().getTime();
        var duration = totalTime - timeLeft;
        $("#taskDuration").val(Math.round(duration));
    }
});
