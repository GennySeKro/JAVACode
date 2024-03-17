package LCR;

import HOT.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LCR031 {
    /*
    LRU缓存
     */

    class LRUCache {
        // 保证get && put方法的时间复杂度为O（1）
        //（1）hashmap用来存储 值和其在双向链表中对应的链表节点;
        //（2）使用双向链表，来存储 最近使用过的值;
        class TwoListNode{
            // 双向链表节点
            // 1.key-value键值对
            int key;
            int val;
            // 2.pre-next指针
            TwoListNode pre;
            TwoListNode next;
            // 3.无参&&有参构造方法
            public TwoListNode(){}
            public TwoListNode(Integer key , Integer val){
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer , TwoListNode> hashmap;
        // 双向链表的头结点 && 尾节点
        TwoListNode head;
        TwoListNode tail;
        // 双向链表的最大容量
        Integer capacity;
        // 当前双向链表中所存储记录的数量（即，当前双向链表的长度）
        Integer size;

        public LRUCache(int capacity) {
            hashmap  = new HashMap<>();
            this.capacity = capacity;
            size = 0;
            // 初始化时，有且仅有头结点和尾节点，头结点和尾节点相互指向;
            head = new TwoListNode();
            tail = new TwoListNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            // 情况 ：hashmap中存在此key对应的链表节点;
            if(hashmap.containsKey(key)){
                TwoListNode node = hashmap.get(key);
                // 将当前key所对应的链表节点移动到双向链表头部
                MoveNodeToHead(node);
                return node.val;
            }
            // 情况 ：hashmap中不存在此key对应的链表节点;
            else{
                return -1;
            }
        }

        public void put(int key, int value) {
            // 该key存在的情况 ：
            if(hashmap.containsKey(key)){
                // 获取到当前key在双向链表中的节点
                TwoListNode node = hashmap.get(key);
                // 更新数据值
                node.val = value;
                // 同时将该链表节点移动到链表头部
                MoveNodeToHead(node);
            }
            // 该key不存在的情况 ：
            else{
                // 直接添加到双向链表头部
                TwoListNode node = new TwoListNode(key , value);
                AddNodeToHead(node);
                hashmap.put(key , node);
                size++;
                // 若是当前双向链表的长度 > 最大容量的话，则选择将链表尾节点删除
                if(size > capacity){
                    // 在双向链表中，删除链表尾节点
                    TwoListNode pollNode = removeTailNode();
                    // 将链表尾节点在hashmap中对应的记录删除;
                    hashmap.remove(pollNode.key);
                    size--;
                }
            }
        }
        // 在双向链表中，删除指定节点;
        public void removeNode(TwoListNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 将双向链表中某个节点，移动到双向链表的头部
        public void MoveNodeToHead(TwoListNode node){
            removeNode(node);
            AddNodeToHead(node);
        }
        // 将参数所传递进来的新节点，添加到双向链表的头部
        public void AddNodeToHead(TwoListNode node){
            // node节点移动到head节点后;
            // head节点next指针指向node节点，head.next节点的pre指针指向node节点
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }
        // 删除双向链表的尾节点
        public TwoListNode removeTailNode(){
            TwoListNode pollNode = tail.pre;
            removeNode(pollNode);
            return pollNode;
        }
    }
}
