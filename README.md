# Models

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[ ![Download](https://api.bintray.com/packages/peng571/maven/tool-datalist/images/download.svg) ](https://bintray.com/peng571/pengyr_library/tool-datalist/_latestVersion)

針對自訂的模組提供一系列的封裝，可簡單的在app中管理，並套入列表中使用。
皆須採用此library，並根據app所需要的元件選擇採用的library

#### 使用方法

using gradle

    compile 'org.pengyr.tool:models:[last version]'


## Models Recycler list

若需要使用Android support提供的`RecyclerView`，
可以採用此library提供的工具。

使用Gradle

    compile 'org.pengyr.tool:models-recyclerlist:[last version]'

### 提供以下幾種功能的封裝:
- 事件監聽
- 物件包裝
- 列表刷新
- Api回傳陣列
- 分頁


### 事件監聽 (Event Listener)

提供對Recycler list view底下的viewholder做事件監控。

主要提供以下兩種最常用的方法。
- OnItemClickListener(ViewHolder)
- OnItemLongClickListener(ViewHolder)

##### 使用方法

###### 搭配ListRecyclerAdapter

使用ListRecyclerAdapter，可直接針對要監聽的adapter，設置listener，
則會在view hodler建立時自動加入監聽，如以下所示


    adapter.setOnItemClickListener(clickListener);
    adapter.setOnItemLongClickListener(longClickListener);

###### 針對ModelRowHolder

若是使用或是Android原生的RecyclerView.Adapter或其他Library提供的的Adapter，
又或者需要針對特定的viewholder，設定不同的event listener，例如Header，
可搭配`ModelRowHolder.listen(eventListener)`來直接設定，
建議可在adapter的onCreateView中直接設定，
若設定了其他的eventListener，則會在該viewholder上取代掉原本對adapter設定的事件。

##### 擴充

若要自行設定其他event，例如touchEvent，則可直接繼承`RecycleRowEventListener`來做擴充。

### Provider

Provider是針對Adpater，提供需要顯示的物件陣列，主要是以List做封裝，使用方法跟一般使用List的方法類似。

若是不使用ListRecyclerAdapter，或需要將物件與adapter分開，或需要再多個列表顯示相同的物件群組，
則可以使用原生的Recyler.Adapter搭配provider使用。

#### 使用方法

在頁面載入的時候

    provider.bind(adapter)

在頁面關閉的時候

    provider.unbind(adapter)


##### positionFixer

若是Adapter裡需要顯示特殊固定物件，例如Header、Footer或其他，
可針對Provider設置positionFixer。

##### notify

可在物件變更的同時，就對需要響應變更的provider設置變更，
會被自動存入notify集合中，當adapter出現的同時才刷新，
可避免在adapter未顯示時刷新adapter內資料會遇到的錯誤。


##### Refreshable

`RefreshModelProvider`繼承自KeyModelProvider，提供列表對server提供資料的刷新和分頁功能。

可透過在bind的同時設定以下物件，來控制。

- PagingOption : 分頁設定
- OnRefreshListener<P> : 刷新事件監聽
- RefreshCellHolder<M, P> : 刷新時候server溝通的物件，目前僅針對retrofit做封裝


### Parser

針對server提供的物件和provider中實際使用的物件不同時做轉換。

若是將物件轉換成物件ID來儲存在列表中，可以使用KeyModelProvider，其中使用的物件需時做KeyModel介面。

若是需轉換成其他物件，則可使用DataProvider實作。




## Models Recycler list


若需要使用Android原生的`RecyclerView.Adapter`，
可以採用此library提供的工具。

使用Gradle

    compile 'org.pengyr.tool:models-list:[last version]'

