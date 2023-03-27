// const card = document.querySelector(".map-card");
// const cardBody = card.querySelector(".card-body");

// card.addEventListener("click", () => {
//   cardBody.classList.toggle("closed");
// });

// const loginId = document.getElementById('loginName');
// const loginPw = document.getElementById('loginPassword');
// const loginBtn = document.getElementById('loginButton');

window.onload = function () {
  if (JSON.parse(localStorage.getItem("check")) == true) {
    //로그인 - display:none
    document.querySelector("#header_nav_confirm_off").style.display = "none";
    //로그아웃, 관리자 - display:block
    document.querySelector("#header_nav_confirm_on").style.display = "block";

    // location.replace("index.html");
    // return;
  } else {
    //로그인 - display:none
    document.querySelector("#header_nav_confirm_off").style.display = "block";
    //로그아웃, 관리자 - display:block
    document.querySelector("#header_nav_confirm_on").style.display = "none";
  }
};

function regist() {
  // 문서에서 id 로 input data 가져오기
  let registerName = document.getElementById("registerName").value;
  let registerId = document.getElementById("registerId").value;
  let registerPassword = document.getElementById("registerPassword").value;
  let registerRepeatPassword = document.getElementById("registerRepeatPassword").value;

  // 입력값 검증
  if (
    registerName.length == 0 ||
    registerId.length == 0 ||
    registerPassword.length == 0 ||
    registerRepeatPassword.length == 0
  ) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    // input data로 user 만들기
    const user = {
      id: registerId,
      password: registerPassword,
      name: registerName,
    };
    console.log(user);

    // user 객체 문자열로 바꿔서 로컬스토리지에 저장
    localStorage.setItem("user", JSON.stringify(user));
    alert("사용자 등록 성공!");
    // 로그인 화면으로 돌아가기
    location.replace("signUpAndSignIn.html");
  }
}

function login() {
  // 문서에서 id로 input data 가져오기
  let id = document.getElementById("loginId").value;
  let password = document.getElementById("loginPassword").value;

  // 로컬스토리지에 "user" 키로 저장된 item 가져와서 json 객체로 만들기
  const user = JSON.parse(localStorage.getItem("user"));
  // 입력값 검증
  if (user.id && user.password && user.id == id && user.password == password) {
    localStorage.setItem("check", true);
  } else {
    localStorage.setItem("check", false);
  }
  if (JSON.parse(localStorage.getItem("check")) == true) {
    alert("로그인 성공 !");
    //로그인 - display:none
    document.querySelector("#header_nav_confirm_off").style.display = "none";
    //로그아웃, 관리자 - display:block
    document.querySelector("#header_nav_confirm_on").style.display = "block";

    location.replace("index.html");
  } else {
    alert("로그인 실패 !");
    //로그인 - display:none
    document.querySelector("#header_nav_confirm_off").style.display = "block";
    //로그아웃, 관리자 - display:block
    document.querySelector("#header_nav_confirm_on").style.display = "none";
  }
}

function logout() {
  alert("로그아웃 되었습니다.");
  document.querySelector("#header_nav_confirm_off").style.display = "block";
  //로그아웃, 관리자 - display:block
  document.querySelector("#header_nav_confirm_on").style.display = "none";
  localStorage.setItem("check", false);
}

function withdrawal() {
  localStorage.removeItem("user");
  alert("회원탈퇴 되었습니다");
  document.querySelector("#header_nav_confirm_off").style.display = "block";
  //로그아웃, 관리자 - display:block
  document.querySelector("#header_nav_confirm_on").style.display = "none";
  localStorage.setItem("check", false);
}
