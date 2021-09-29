package MergeSort;

@SuppressWarnings("all")
public class MergeSort<T extends Comparable<? super T>> {

    T[] output;

    MergeSort(){}

    /** This method implements the merge sort algorithm
     * @Calls mergeSort(T[] array,T[] array2,int left,int right) */
    public void mergeSort(T[] array){
        mergeSort(array,array.clone(),0,array.length);
    }

    /** This method implements the merge-sort algorithm
     * @param array - the array to be sorted
     * @param array2 - help array for sorting the array
     * @param left - first index of the array
     * @param right - last index of the array */
    private void mergeSort(T[] array,T[] array2,int left,int right){
        if(left+1<right){
            int middle = (left+right)/2; //calculate mid element
            mergeSort(array,array2,middle,right); //split the array's first part
            mergeSort(array,array2,left,middle);//split the array's second part
            merge(array,array2.clone(),left,middle,right);
        }
    }

    /** This method implements the merging part of the merge sort algorithm
     * @param array - the array that will be reordered
     * @param array2 - help array for replacing the elements without changing first array
     * @param left - first index of the array
     * @param middle - middle index of the array
     * @param right - last index in the array */
    private void merge(T[] array,T[] array2,int left,int middle,int right){
        int first = left; //First pointer starts at the beginning of the array
        int second = middle; //Second pointer starts in the middle
        int positionInSecondArray = left; //Third pointer starts at first location in the second array
        while (first<middle || second<right){ // while(!((first>=middle)&&(second>=right))) - as long as the first hasnt
            // reached the middle and the second hasnt arrived at the end yet
            if(second==right||first<middle&&array[first].compareTo(array[second])<=0){ // if the second element arrived at
                // the end OR the first element hasn't arrived at the middle AND he current element ist smaller than or
                //equals that in the second array half
                array2[positionInSecondArray++] = array[first++];//replace element in second array with that in the first
            }
            else{
                array2[positionInSecondArray++] = array[second++]; //else replace the elements after the middle of the array
            }
        }
        for(positionInSecondArray=left;positionInSecondArray<right;positionInSecondArray++){
            array[positionInSecondArray]=array2[positionInSecondArray]; //replace elements in the normal array with those
            //of the second array, hence it will be returned in the end
        }
    }
}
