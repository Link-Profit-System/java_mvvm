# memo

### 環境
- Windows
- サーバーサイド
  - JAVA
    - フレームワーク：Quarkus
  - DB
    - PostgreSQL
  - ビルドツール
    - gradle
  - 他
    - IntelliJ
    - Lombok
    - GitHub Copilot
    - docker desktop
- WSL上に資材を配置、SSHを使用してSourceTreeとGITを連結
- 自動作成される資材はWSL上に作成される点に注意
- WSLで下記を入力し作成
```shell script
quarkus create app lps_dev --gradle --extension="quarkus-jooq,quarkus-jdbc-postgresql,hibernate-orm-panache"
```

### 構築で苦労した点
- SSHの秘密キー
  - GITとの連携のために事前に秘密キーを作成していた場合、SourceTreeはその秘密キーを読み込み使用する。新たに作成した場合、SourceTreeからGITに接続できない。今回の構成の場合は、秘密キーは1つで良い。
  - 秘密キーのタイプによってはSourceTreeからGITに接続できないため、秘密キーの作成時に注意が必要。
- SourceTree
  - フォルダ検索ではWSLが読み取れない。直接入力。
  - SourceTreeの「ツール > SSH エージェントを起動」を押下してもPageantが起動していないように見えるが、Dockerなどと同様で右下の「隠れているインジケーター」に存在している。ダブルクリックで表示し、秘密キーを選択する。
  - リポジトリの作成は空のフォルダのみ可能。また、Quarkus CLIによるプロジェクトの作成もフォルダが存在すると実施不可。空のフォルダ作成 > SourceTreeからリポジトリ作成 > 「フォルダ内」にプロジェクトを作成。
- WindowsのPowerShellでは「curl」というコマンドに別のツールが割り当てられていいる模様。標準の「curl」もあるため、そちらを使用したい場合は、エイリアスを削除すれば使用可能。
- Shellにて、「java」や「gradle」のコマンドが動かない場合、対象のインストールと環境変数の設定が必要。
- docker desktopのバージョンアップで、Hyper-Vのメモリ関連のエラーが発生。docker desktopの再インストールでエラー解消。既存コンテナが消えるため注意。
- JAVA_HOMEの設定はubuntu上のため通常とは異なる。
