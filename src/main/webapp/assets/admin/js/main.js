 //switch admin post trending
    $('.slider').click(function () {
        var postId = $(this).children().val();
        var checkStatus = $(this).parent().children()[0].checked;
        console.log(postId)
        console.log(checkStatus)
        $.ajax({
            url: "SwitchPostTrending",
            type: "GET",
            cache: false,
            data: {
                id: postId,
                status: !checkStatus
            },
            success: function (data) {
                alert("Chuyển trạng thái thành công");
            }, error: function (err) {
                alert('Đã xảy ra lỗi, vui lòng thử lại !');
            }
        });
    });