# memo

### 環境
- Windows_WSL2
- フロントエンド
  - Vue.js
  - UIフレームワーク
    - Bootstrap
  - ライブラリ
    - axios
    - vue-sweetalert2
  - 他
    - Visual Studio Code
    - GitHub Copilot
    - Gemini Code Assist
- バックエンド
  - JAVA
    - フレームワーク：Quarkus
  - DB
    - PostgreSQL
  - ビルドツール
    - gradle
  - コンテナ
    - docker desktop
  - ライブラリ
    - jooq（データベーススキーマに基づいてJavaコードを自動生成。プレフィクス/サフィックスも追加。）
    - jakarta（RESTful API）
  - 認証
    - JWT
    - CORS
  - 他
    - IntelliJ
    - Lombok
    - GitHub Copilot
    - Gemini Code Assist
    - Talend API Tester（Chrome拡張機能）
    - 他プロジェクト作成のために色々インストール
- WSL上に資材を配置、SSHを使用してSourceTreeとGITを連結
- 自動作成される資材はWSL上に作成される点に注意
- WSLで下記を入力し作成
```shell script
quarkus create app lps_dev --gradle --extension="quarkus-jooq,quarkus-jdbc-postgresql,hibernate-orm-panache"
```

### 構築で苦労した点
- 共通
  - 自動生成 > GITにPUSH > 通常のローカルで作成継続 のほうが良かったかも。。。
- フロントエンド
  - エラー原因の判断が難しい。
    - Vue.jsのバージョン「Vue.js 3」と「Vue.js 2」の記述方法の差異。
    - ライブラリの有無。
- バックエンド
  - SSHの秘密キー
    - GITとの連携のために事前に秘密キーを作成していた場合、SourceTreeはその秘密キーを読み込み使用する。新たに作成した場合、SourceTreeからGITに接続できない。今回の構成の場合は、秘密キーは1つで良い。
    - 秘密キーのタイプによってはSourceTreeからGITに接続できないため、秘密キーの作成時に注意が必要。
  - SourceTree
    - フォルダ検索ではWSLが読み取れない。直接入力。
    - SourceTreeの「ツール > SSH エージェントを起動」を押下してもPageantが起動していないように見えるが、Dockerなどと同様で右下の「隠れているインジケーター」に存在している。ダブルクリックで表示し、秘密キーを選択する。
    - リポジトリの作成は空のフォルダのみ可能。また、Quarkus CLIによるプロジェクトの作成もフォルダが存在すると実施不可。空のフォルダ作成 > SourceTreeからリポジトリ作成 > 「フォルダ内」にプロジェクトを作成。
    - SourceTreeが開かなくなる。不要なファイルが作成されているため対象を削除。（初期化されてしまうので注意）
  - WindowsのPowerShellでは「curl」というコマンドに別のツールが割り当てられていいる模様。標準の「curl」もあるため、そちらを使用したい場合は、エイリアスを削除すれば使用可能。
  - Shellにて、「java」や「gradle」のコマンドが動かない場合、対象のインストールと環境変数の設定が必要。
  - docker desktopのバージョンアップで、Hyper-Vのメモリ関連のエラーが発生。docker desktopの再インストールでエラー解消。既存コンテナが消えるため注意。
  - IntelliJのJDKの設定がはずれてしまう。原因は不明。ubuntu上にJDKをダウンロードした場合のJAVA_HOMEの設定は通常とは異なる点に注意。
  - PostgresQLのテーブル/データをA5:...で作成したが、なぜか対象が異なり取得できない。psqlコマンドの「docker exec -it <コンテナ名> psql -U <ユーザー名>」を用いて直接SQLでテーブル/データを投入すると取得成功。
    - ローカルとDockerの両方のPostgresQLが起動しており、更にPortが一緒の場合に発生する。A5:SQLではローカルを、アプリではDockerのDBに接続する状態になっていた。
  - プロジェクトの読み込みがリアルタイムで実施されない。再読み込みが必要？
  - Talend Api Tester
    - 認証はトークンのみでOK（JWT認証のみのため）。項目「Authorization」、設定値「Bearer eyJ0eXAiOi...」なので注意。
