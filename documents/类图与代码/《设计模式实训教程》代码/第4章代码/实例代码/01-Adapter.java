//抽象数据操作类：目标接口
interface DataOperation
{
	public int[] sort(int array[]);
	public int search(int array[],int key);
}

//快速排序类：适配者
class QuickSort
{
	public int[] quickSort(int array[])
	{
		sort(array,0,array.length-1);
		return array;
	}

	public void sort(int array[],int p, int r)
	{
		int q=0;
		if(p<r)
		{
			q=partition(array,p,r);
			sort(array,p,q-1);
            sort(array,q+1,r);
		}
	}
	
	public int partition(int[] a, int p, int r)
	{
		int x=a[r];
		int j=p-1;
		for(int i=p;i<=r-1;i++)
		{
			if(a[i]<=x)
			{
				j++;
				swap(a,j,i);
			}
		}
		swap(a,j+1,r);
		return j+1;	
	}
	
	public void swap(int[] a, int i, int j) 
	{   
        int t = a[i];   
        a[i] = a[j];   
        a[j] = t;   
	}
}

//二分查找类：适配者
class BinarySearch
{
	public int binarySearch(int array[],int key)
	{
		int low = 0;
		int high = array.length -1;
		while(low <= high)
		{
			int mid = (low + high) / 2;
			int midVal = array[mid];
			
			if(midVal < key)
			{
				low = mid +1;
			}
			else if(midVal > key)
			{
				high = mid -1;
			}
			else 
			{
				return 1; //找到元素返回1
			}
		}
		return -1;  //未找到元素返回-1
	}
}

//操作适配器：适配器
class OperationAdapter implements DataOperation
{
	private QuickSort sortObj;
	private BinarySearch searchObj;
	public OperationAdapter(QuickSort sortObj,BinarySearch searchObj)
	{
		this.sortObj = sortObj;
		this.searchObj = searchObj;
	}
	public int[] sort(int array[])
	{
		return sortObj.quickSort(array);
	}
	public int search(int array[],int key)
	{
		return searchObj.binarySearch(array,key);
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		DataOperation operation;  //针对抽象目标接口编程
		QuickSort sortObj = new QuickSort();
		BinarySearch searchObj = new BinarySearch();
		operation = new OperationAdapter(sortObj,searchObj);
		int array[] = {13,24,15,36,26,17,68,34};
		int result[];
		int value;
		
		System.out.println("排序结果：");
		result = operation.sort(array);
		for(int i:array)
		{
			System.out.print(i + ",");
		}
		System.out.println();
		
		System.out.println("查找关键字24：");
		value = operation.search(result,24);
		if(value!=-1)
		{
			System.out.println("找到关键字24。");
		}
		else
		{
			System.out.println("没有找到关键字24。");
		}
		
		System.out.println("查找关键字25：");
		value = operation.search(result,25);
		if(value!=-1)
		{
			System.out.println("找到关键字25。");
		}
		else
		{
			System.out.println("没有找到关键字25。");
		}
	}
}