import java.util.*;

public class Sorts
{
  public void bubbleSort(int[] list)
  {
    for (int i=0; i<list.length-1; i++){
      for (int p=0; p<list.length-i-1; p++){
        if (list[p]>list[p+1]){
          int temporary=list[p];
          list[p]=list[p+1];
          list[p+1]=temporary;
        }
      }
    }
  }

  public void selectionSort(int[] list)
  {
    int flag, temp;
    for (int outer = 0; outer < list.length - 1; outer++){
      flag = outer;  
      for (int inner = outer + 1; inner < list.length; inner++){
        if (list[inner] < list[flag]){
          flag = inner;
        }
      }
      //swap list[outer] & list[flag]
      temp = list[outer];
      list[outer] = list[flag];
      list[flag] = temp;
    }
  }

  public void insertionSort(int[] list)
  {
    for (int outer = 1; outer < list.length; outer++){
      int position = outer;
      int key = list[position];
    
      // Shift larger values to the right
      while (position > 0 && list[position - 1] > key){
        list[position] = list[position - 1];
        position--;
      }
      list[position] = key;
    }
  }

  private void merge(int[] a, int first, int mid, int last)
  {
    int[] temp=new int[a.length];
    for (int p=first; p<=last; p++){
      temp[p]=a[p];
    }
    int nA=first;
    int nB=mid+1;
    for (int i=first; i<=last; i++){
      if (nA>mid){
        temp[i]=a[nB];
        nB++;
      }
      else if (nB>last){
        temp[i]=a[nA];
        nA++;
      }
      else if (a[nA]<a[nB]){
        temp[i]=a[nA];
        nA++;
      }
      else {
        temp[i]=a[nB];
        nB++;
      }
    }
    for (int p=first; p<=last; p++){
      a[p]=temp[p];
    }
  }

  public void mergeSort(int[] a, int first, int last)
  {
    int mid=(first+last)/2;
    if (first!=last){
      mergeSort(a,first,mid);
      mergeSort(a,mid+1,last);
    }
    merge(a,first,mid,last);
  }
}

