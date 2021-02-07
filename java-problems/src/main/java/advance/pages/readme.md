提到缓存，不得不提就是缓存算法(淘汰算法)，常见算法有LRU、LFU和FIFO等算法，
每种算法各有各的优势和缺点及适应环境。

## LRU(Least Recently Used ，最近最少使用)
算法根据数据的最近访问记录来淘汰数据，其原理是如果数据最近被访问过，将来被访问的几概率相对
比较高，最常见的实现是使用一个链表保存缓存数据，详细具体算法如下：
1. 新数据插入到链表头部；
2. 每当缓存数据命中，则将数据移到链表头部；
3. 当链表满的时候，将链表尾部的数据丢弃；


## LFU(Least Frequently Used，最不经常使用)
算法根据数据的历史访问频率来淘汰数据，其原理是如果数据过去被访问次数越多，将来被访问的几概率
相对比较高。LFU的每个数据块都有一个引用计数，所有数据块按照引用计数排序，具有相同引用计数的
数据块则按照时间排序。
具体算法如下：
1. 新加入数据插入到队列尾部（因为引用计数为1）；
2. 队列中的数据被访问后，引用计数增加，队列重新排序；
3. 当需要淘汰数据时，将已经排序的列表最后的数据块删除；


## FIFO(First In First Out ，先进先出)
算法是根据先进先出原理来淘汰数据的，实现上是最简单的一种,具体算法如下：
1. 新访问的数据插入FIFO队列尾部，数据在FIFO队列中顺序移动；
2. 淘汰FIFO队列头部的数据；


评价一个缓存算法好坏的标准主要有两个，一是命中率要高，二是算法要容易实现。当存在热点数据时，
LRU的效率很好，但偶发性的、周期性的批量操作会导致LRU命中率急剧下降，缓存污染情况比较严重。
LFU效率要优于LRU，且能够避免周期性或者偶发性的操作导致缓存命中率下降的问题。但LFU需要记录
数据的历史访问记录，一旦数据访问模式改变，LFU需要更长时间来适用新的访问模式，即：LFU存在历
史数据影响将来数据的“缓存污染”效用。FIFO虽然实现很简单，但是命中率很低，实际上也很少使用这
种算法。

## ref
- [简单的java缓存实现](https://my.oschina.net/u/866190/blog/188712)