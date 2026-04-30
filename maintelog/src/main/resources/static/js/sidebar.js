// サイドバーのメニューアイテムを定義
const menuData = [
    { name:"ダッシュボード", url:"#",icon:"bi-house-door" },
    { name:"機械情報管理", url:"#",icon:"bi-tools" },
    { name:"メーカー情報管理", url:"#",icon:"bi-wechat" },
]

// サイドバーへメニューアイテムを追加する関数
function loadSidebar() {
    // サイドバーのコンテナをIDから取得
    const sidebarContainer = document.getElementById("sidebar-list");
    // コンテナが存在しない場合はエラーメッセージを表示して終了
    if (!sidebarContainer) {
        console.error("サイドバーのコンテナが見つかりません。");
        return;
    }
    // メニューアイテムのHTMLを生成
    const menuHtml = menuData.map(item => `
                            <li class="nav-item">
                            <a class="nav-link text-dark" href="${item.url}">
                                <i class="bi ${item.icon} me-2"></i>
                                ${item.name}
                            </a>
                        </li>
    `).join('');
    // 生成したHTMLをサイドバーのコンテナに挿入
    sidebarContainer.innerHTML = menuHtml;
}

// ページが読み込まれたときにサイドバーを初期化
document.addEventListener("DOMContentLoaded", loadSidebar);