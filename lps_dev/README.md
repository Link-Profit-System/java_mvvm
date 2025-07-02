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
quarkus create app lps:lps_dev --extension=jooq --extension=jdbc-postgresql --extensions=hibernate-orm-panache --gradle
```

### 構築で苦労した点
- SSHの秘密キー
  - GITとの連携のために事前に秘密キーを作成していた場合、SourceTreeはその秘密キーを読み込み使用する。新たに作成した場合、SourceTreeからGITに接続できない。今回の構成の場合は、秘密キーは1つで良い。
  - 秘密キーのタイプによってはSourceTreeからGITに接続できないため、秘密キーの作成時に注意が必要。
- SourceTreeのフォルダ検索ではWSLが読み取れない。直接入力。
- SourceTreeの「ツール > SSH エージェントを起動」を押下してもPageantが起動していないように見えるが、Dockerなどと同様で右下の「隠れているインジケーター」に存在している。ダブルクリックで表示し、秘密キーを選択する。
- WindowsのPowerShellでは「curl」というコマンドに別のツールが割り当てられていいる模様。標準の「curl」もあるため、そちらを使用したい場合は、エイリアスを削除すれば使用可能。
- Shellにて、「java」や「gradle」のコマンドが動かない場合、対象のインストールと環境変数の設定が必要。
- docker desktopのバージョンアップで、Hyper-Vのメモリ関連のエラーが発生。docker desktopの再インストールでエラー解消。既存コンテナが消えるため注意。



# lps_dev

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.native.enabled=true
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/lps_dev-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/gradle-tooling>.

## Related Guides

- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)

