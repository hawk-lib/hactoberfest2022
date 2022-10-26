#include <limits.h>  
#include <stdio.h>   
#include <stdlib.h>  

typedef struct max_heap {
    int *x;
    int size;
    int heap_count;
} Heap;

Heap *create_heap(Heap *heap); 
void down_heapify(Heap *heap, int index); 
void up_heapify(Heap *heap, int index); 
void heap_push(Heap *heap, int x);           
void heap_pop(Heap *heap); 
int heap_top(Heap *heap); 
int heap_empty(Heap *heap); 
int heap_size(Heap *heap);  

int main() {
    Heap *head = create_heap(head);
    heap_push(head, 19125052);
    printf("Pushing Element : 19125052\n");
    heap_push(head, 19125003);
    printf("Pushing Element : 19125003\n");
    heap_push(head, 19125002);
    printf("Pushing Element : 19125002\n");
    heap_push(head, 19125008);
    printf("Pushing Element : 19125008\n");
    printf("Top Element = %d \n", heap_top(head));
    heap_push(head, 19125001);
    printf("Pushing Element : 19125001\n");
    heap_push(head, 19125007);
    printf("Pushing Element : 19125007\n");
    printf("Top Element = %d \n", heap_top(head));
    heap_pop(head);
    printf("Popping An Element...\n");
    printf("Top Element = %d \n", heap_top(head));
    heap_pop(head);
    printf("Popping An Element...\n");
    printf("Top Element = %d \n", heap_top(head));
    printf("\n");
    return 0;
}

Heap *create_heap(Heap *heap) {
    heap = (Heap *)malloc(sizeof(Heap));
    heap -> size = 1;
    heap -> x = (int *)malloc(heap -> size * sizeof(int));
    heap -> heap_count = 0;
    return heap;
}

void down_heapify(Heap *heap, int index) {
    if (index >= heap -> heap_count) {
        return;
    }
    int heapleft = index * 2 + 1;
    int heapright = index * 2 + 2;
    int left_flag = 0, right_flag = 0;
    int heap_maxima = *((heap -> x) + index);

    if (heapleft < heap -> heap_count && heap_maxima < *((heap -> x) + heapleft)) {
        heap_maxima = *((heap -> x) + heapleft);
        left_flag = 1;
    }

    if (heapright < heap -> heap_count && heap_maxima < *((heap -> x) + heapright)) {
        heap_maxima = *((heap -> x) + heapright);
        left_flag = 0;
        right_flag = 1;
    }

    if (left_flag) {
        *((heap -> x) + heapleft) = *((heap -> x) + index);
        *((heap -> x) + index) = heap_maxima;
        down_heapify(heap, heapleft);
    }

    if (right_flag) {
        *((heap -> x) + heapright) = *((heap -> x) + index);
        *((heap -> x) + index) = heap_maxima;
        down_heapify(heap, heapright);
    }
}

void up_heapify(Heap *heap, int index) {
    int parent = (index - 1) / 2;
    if (parent < 0) {
        return;
    }
    if (*((heap -> x) + index) > *((heap -> x) + parent)) {
        int temp = *((heap -> x) + index);
        *((heap -> x) + index) = *((heap -> x) + parent);
        *((heap -> x) + parent) = temp;
        up_heapify(heap, parent);
    }
}

void heap_push(Heap *heap, int x) {
    if (heap -> heap_count >= heap -> size) {
        return;
    }
    *((heap -> x) + heap -> heap_count) = x;
    heap -> heap_count++;
    if (4 * heap -> heap_count >= 3 * heap -> size) {
        heap -> size *= 2;
        (heap -> x) = (int *)realloc((heap -> x), (heap -> size) * sizeof(int));
    }
    up_heapify(heap, heap->heap_count - 1);
}

void heap_pop(Heap *heap) {
    if (heap->heap_count == 0) {
        return;
    }
    heap -> heap_count--;
    int temp = *((heap -> x) + heap -> heap_count);
    *((heap -> x) + heap -> heap_count) = *(heap -> x);
    *(heap -> x) = temp;
    down_heapify(heap, 0);
    if (4 * heap -> heap_count <= heap -> size) {
        heap -> size /= 2;
        (heap -> x) = (int *)realloc((heap -> x), (heap -> size) * sizeof(int));
    }
}

int heap_top(Heap *heap) {
    if (heap -> heap_count != 0) {
        return *(heap -> x);
    }
    else {
        return INT_MIN;
    }
}

int heap_empty(Heap *heap) {
    
    if (heap -> heap_count != 0) {
        return 0;
    }
    else {
        return 1;
    }
}

int heap_size(Heap *heap) { 
    return heap -> heap_count; 
}