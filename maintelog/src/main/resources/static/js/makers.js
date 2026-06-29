// ターゲットの取得
const sidebarList = document.getElementById('sidebar-list');

// メーカー情報をAPIから取得して表示する関数
async function loadMakers() {
    try {
        // APIエンドポイントからメーカー情報を取得
        const response = await fetch('http://localhost:8080/makerList');
        
        // HTTPエラーが発生した場合は例外をスロー
        if (!response.ok) {
            throw new Error(`HTTPエラー: ${response.status}`);
        }
        // レスポンスをJSON形式で解析
        const makers = await response.json();

        //メインコンテンツ部分のタイトルを更新
        document.getElementById('main-title').textContent = 'メーカー情報管理';

        // メーカー情報を表示する場所を取得
        const makersList = document.getElementById('main-content');
       
        // 既存の内容をクリア
        while (makersList.children.length > 1) {
            makersList.removeChild(makersList.children[1]);
        }

        //メーカー情報を一覧表示するためのリストグループ要素を作成
        const makersDiv = document.createElement('div');
        makersDiv.className = "list-group col-12 col-md-7 mx-auto";
        makersList.append(makersDiv);
       
        // メーカー情報を追加
        makers.forEach(maker => {
       
            //リストグループのアイテムを格納する要素を作成
            const makerDiv = document.createElement('div');
            makerDiv.className = "list-group-item list-group-item-action";
            makerDiv.onclick = function() {
       
                todo: メーカー情報がクリックされたときの処理を実装
                alert('メーカー情報がクリックされました！');
            }
            makersDiv.append(makerDiv);
       
            //リストグループのアイテムにメーカー情報を表示
            const header = document.createElement('div');
            header.className = "d-flex w-100 justify-content-between";
            makerDiv.append(header);
       
            //メーカーIDとメーカー名を表示
            const title = document.createElement('h5');
            title.className = "mb-1";
            title.textContent = `${maker.maker}`;
            header.append(title);
            const id = document.createElement('small');
            id.textContent = `ID: ${maker.id}`;
            header.append(id);
       
            //メーカーの住所、電話番号、FAX番号を表示
            const address = document.createElement('p');
            address.className = "mb-1";
            address.textContent = `${maker.address}`;
            makerDiv.append(address);
            const tell = document.createElement('small');
            tell.className = "d-block";
            tell.textContent = `電話番号: ${maker.tell}`;
            makerDiv.append(tell);
            const fax = document.createElement('small');
            fax.className = "d-block";
            fax.textContent = `FAX番号: ${maker.fax}`;
            makerDiv.append(fax);
        });
    } catch (error) {
        // エラーが発生した場合はコンソールにエラーメッセージを表示
        console.error('メーカー情報の取得に失敗:', error);
        document.getElementById('main-container').textContent = 'メーカー情報の取得に失敗しました。';
    }
}
// 親要素に対してクリックイベントを設定
sidebarList.addEventListener('click', function(event) {
    //操作された子要素を取得
    const link = event.target;
    // クリックされた要素が makers-link かを判定
    if (link.id === 'makers-link') {
        loadMakers();
    }
});
