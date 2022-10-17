public class binarysearch {
    int Binary(int arr[],int search)
	{
		int low=0,mid=0;
		int high=(arr.length)-1;
		while(low<=high)
		{
			mid=low+(high-low)/2;
		
		if(search<arr[mid])
		{
			high=mid-1;
		}
		else if(search>arr[mid])
		{
			low=mid+1;
		}
		else
		{
			return mid;
		}
		}
		return -1;
		}

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
				
		int a=0;
		BinarySearch ol=new BinarySearch();
		a=ol.Binary(arr,3);
		System.out.println(a);
		}
	}
    
