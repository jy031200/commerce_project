function home() {
    window.location.href = "/index.jsp";
}

function redirectToLogin() {
    window.location.href = "/login.jsp";
}

function mypage(){
    window.location.href = "/mypage.jsp";
}

function myinfo() {
    window.location.href = "/mypage_info.jsp";
}

function deldata(id) {
    if (confirm("정말 탈퇴하시겠습니까?")) {
        fetch(`/mypage?id=${encodeURIComponent(id)}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(text => {
                        throw new Error(`서버 응답 오류: ${text}`);
                    });
                }
                return response.json();
            })
            .then(data => {
                alert(data.message);
                window.location.href = '/index.jsp';
            })
            .catch(error => {
                alert('오류가 발생했습니다: ' + error.message);
            });
    }
}
