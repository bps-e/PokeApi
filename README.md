# PokeApi

Jetpack Compose環境でPokeApi(https://pokeapi.co/) を使用するためのAndroid Libraryです</br>
</br>
動作にはcom.bps-e.HppClient が必要です</br>
https://github.com/bps-e/HttpClient</br>
</br>

## 対応API

・pokemon</br>
・pokemon-species</br>
・ability</br>
・type</br>
・move</br>
・stat</br>

## 依存関係

### org.jetbrains.kotlinx:kotlinx-serialization-json

・build.gradle.kts(Project)
```kotlin
plugins {
    kotlin("plugin.serialization") version "1.9.0"
}
```

・build.gradle.kts(Module)
```kotlin
plugins {
    id("kotlinx-serialization")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}
```

### com.bps-e.HppClient

・build.gradle.kts(Module)
```kotlin
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
}
```

## 使い方

GitHub(https://github.com/bps-e/PokeApi) releaseから.aarをダウンロードして以下にコピーします</br>
(project)/(module)/libs/com.bps-e.PokeApi_x.x.x.aar

・build.gradle.kts(Module)
※ com.bps-e.HppClientの設定をしている場合は不要(重複して指定しない)
```kotlin
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
}
```

実際に使用する場合はリクエスト数が多くなりすぎないように配慮してください<br>
<br>
必要なタイミングで必要なだけリクエストを実行しリクエストしたデータはローカルDBなどに保存してください<br>
PokeApiから攻撃的と判断された場合アクセスしたアドレスがブロックされる場合があります

## 実装例

```kotlin
val scope = rememberCoroutineScope()
var job: Job? by remember { mutableStateOf(null) }

if (job == null || job!!.isCompleted || job!!.isCancelled) {
    job = scope.launch {
        PokeApi.Pokemon {
            //...
        }
    }
}
```
