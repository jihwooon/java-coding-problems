package org.example.algorithm;

public class MergeSort {
    // 병합 정렬 메인 함수
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 중간 지점 찾기
            int mid = (left + right) / 2;

            // 왼쪽 부분 정렬
            mergeSort(arr, left, mid);
            // 오른쪽 부분 정렬
            mergeSort(arr, mid + 1, right);

            // 정렬된 두 부분 병합
            merge(arr, left, mid, right);
        }
    }

    // 두 정렬된 부분 배열을 병합하는 함수
    private static void merge(int[] arr, int left, int mid, int right) {
        // 임시 배열 생성
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // 두 부분 배열을 비교하며 임시 배열에 병합
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 남은 요소들 복사
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 임시 배열의 내용을 원래 배열에 복사
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // 테스트를 위한 main 메소드
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("정렬 전 배열:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\n정렬 후 배열:");
        printArray(arr);
    }

    // 배열 출력 함수
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
