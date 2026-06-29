// サイドバーのメニューアイテムを定義
const menuData = [
    { name:"ダッシュボード", id:"dashboard-link",icon:"bi-house-door" },
    { name:"機械情報管理", id:"machines-link",icon:"bi-tools" },
    { name:"メーカー情報管理", id:"makers-link",icon:"bi-wechat" },
]
// サイドバーへメニューアイテムを追加する関数
function loadSidebar() {
    // サイドバーのコンテナをIDから取得
    const sidebarContainer = document.getElementById("sidebar-list");
    // コンテナが存在しない場合はエラーログを表示して終了
    if (!sidebarContainer) {
        console.error("サイドバーのコンテナが見つかりません。");
        return;
    }
    // メニューアイテムのHTMLを生成
    const menuHtml = menuData.map(item => `
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#" id="${item.id}">
                                <i class="bi ${item.icon} me-2"></i>
                                ${item.name}
                            </a>
                        </li>
    `).join('');
    // 生成したHTMLをサイドバーのコンテナに挿入
    sidebarContainer.innerHTML = menuHtml;
}

document.addEventListener("DOMContentLoaded", function() {
    loadSidebar();
    // メニューのリスト要素を取得
    const sidebarItems = document.getElementsByClassName("nav-item");
    console.log("サイドバーのメニューアイテム数:", sidebarItems.length);
    //メニューアイテムにクリックイベントを追加
    for (let i = 0; i < sidebarItems.length; i++) {
        sidebarItems[i].addEventListener('click', function(event) {
            const offcanvasElement = document.getElementById('sidebarMenu');
            const offcanvasInstance = bootstrap.Offcanvas.getInstance(offcanvasElement);
            offcanvasInstance.hide();
        });
    };
})
