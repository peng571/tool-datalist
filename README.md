# Models

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[ ![Download](https://api.bintray.com/packages/peng571/maven/tool-datalist/images/download.svg) ](https://bintray.com/peng571/pengyr_library/tool-datalist/_latestVersion)

針對自訂的模組提供一系列的封裝，可簡單的在app中管理，並套入列表中使用。
皆須採用此library，並根據app所需要的元件選擇採用的library

#### 使用方法

using gradle

    compile 'org.pengyr.tool:models:[last version]'

using maven

    <dependency>
        <groupId>org.pengyr.tool</groupId>
        <artifactId>models-recyclerlist</artifactId>
        <version>[last version]</version>
        <type>pom</type>
    </dependency>

#### Model


## Models Recycler list

若需要使用Android support提供的`Recycler list`，
可以採用此library提供的工具。

使用Gradle

    compile 'org.pengyr.tool:models-recyclerlist:[last version]'


### 事件 (Event)

提供對Recycler list view底下的viewholder做事件監控。

主要提供以下兩種最常用的方法。
- OnItemClickListener(ViewHolder)
- OnItemLongClickListener(ViewHolder)

###### 使用方法

直接針對要監聽的adapter，設置listener，
如以下所示，
則會在view hodler建立時自動加入監聽。

    adapter.setOnItemClickListener(clickListener);
    adapter.setOnItemLongClickListener(longClickListener);



若需要增加新的event，可複寫RecyclerRowEventListener。

> TODO 在sample中加入範例





## Models Data list

針對傳統的list view，設計的工具。


使用Gradle

    compile 'org.pengyr.tool:models-datalist:[last version]'

> 未完成。
