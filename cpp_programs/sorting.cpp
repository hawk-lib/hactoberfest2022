#include <bits/stdc++.h>
using namespace std;

class student
{
    string name;
    int roll;
    float sgpa;

public:
    void getdata()
    {
        cout << "Enter Name : ";
        cin >> name;
        cout << "Enter Roll no : ";
        cin >> roll;
        cout << "Enter SGPA : ";
        cin >> sgpa;
    }
    void putdata()
    {
        cout << "Name : " << name << endl;
        cout << "Roll no : " << roll << endl;
        cout << "SGPA : " << sgpa << endl;
        cout << "=========================================" << endl;
    }
    void putdata_qs(student s[], int n)
    {
        int x;
        cout << "ENTER NO OF TOPPERS: ";
        cin >> x;
        for (int i = n - 1; i > n - x - 1; i--)
        {
            s[i].putdata();
        }
    }
    void linearsearch(student s[], int n, float key)
    {
        int f = 0;
        for (int i = 0; i < n; i++)
        {
            if (s[i].sgpa == key)
            {
                f = 1;
                s[i].putdata();
                continue;
            }
        }
        if (f == 0)
        {
            cout << "NOT FOUND" << endl;
        }
    }
    void binarysearch(student s[], int n, string key)
    {
        student tmp;
        tmp.bubblesortbyname(s, n);
        int l = 0, r = n - 1, m, f = 0;
        while (l <= r)
        {
            m = (l + r) / 2;
            if (s[m].name < key)
            {
                l = m + 1;
            }
            else if (s[m].name > key)
            {
                r = m - 1;
            }
            else if (s[m].name == key)
            {
                f = 1;
                break;
            }
        }
        if (f == 0)
        {
            cout << "NOT FOUND\n";
        }
        else
        {
            cout << "FOUND\n";
            s[m].putdata();
        }
    }
    void bubblesort(student s[], int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n - 1 - i; j++)
            {
                if (s[j + 1].roll < s[j].roll)
                    swap(s[j + 1], s[j]);
            }
        }
        for (int i = 0; i < n; i++)
        {
            s[i].putdata();
        }
    }
    void bubblesortbyname(student s[], int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n - 1 - i; j++)
            {
                if (s[j + 1].name < s[j].name)
                    swap(s[j + 1], s[j]);
            }
        }
    }
    void insertionSort(student s[], int n)
    {
        int i, j, key;

        for (i = 1; i < n; i++)
        {
            j = i;
            while (j > 0 and s[j].name < s[j - 1].name)
            {
                swap(s[j], s[j - 1]);

                j--;
            }
        }
        for (int i = 0; i < n; i++)
        {
            s[i].putdata();
        }
    }
    int partition(student s[], int l, int h)
    {
        int i = l;
        int j = h;
        float p = s[l].sgpa;
        while (i < j)
        {
            while (p >= s[i].sgpa)
                i++;
            while (p < s[j].sgpa)
                j--;
            if (i < j)
                swap(s[i], s[j]);
        }
        swap(s[l], s[j]);
        return j;
    }

    void quicksort(student s[], int l, int h)
    {
        if (l < h)
        {
            int j = partition(s, l, h);
            quicksort(s, l, j - 1);
            quicksort(s, j + 1, h);
        }
    }
};

int main()
{

    int n;
    cout << "Enter the number of students: ";
    cin >> n;

    student s[n];

    while (true)
    {
        cout << "Press 1: To enter the details of each student" << endl;
        cout << "Press 2: To Display the details of each student" << endl;
        cout << "Press 3: Linear Search by SGPA" << endl;
        cout << "Press 4: Binary Search by NAME" << endl;
        cout << "Press 5: Bubble Sort by ROLL NO" << endl;
        cout << "Press 6: Insertion Sort by NAME" << endl;
        cout << "Press 7: Quick Sort by SGPA" << endl;

        int t;
        cin >> t;

        switch (t)
        {

        case 1:
        {
            cout << "ENTER DETAILS\n\n";
            for (int i = 0; i < n; i++)
            {
                cout << "Student " << i + 1 << "\n\n";
                s[i].getdata();
            }
            break;
        }
        case 2:
        {
            cout << "DISPLAY DETAILS\n\n";
            for (int i = 0; i < n; i++)
            {
                cout << "Student " << i + 1 << "\n\n";
                s[i].putdata();
            }
            break;
        }
        case 3:
        {
            cout << "LINEAR SEARCH\n\n";
            float key;
            cout << "SGPA,you want to search : ";
            cin >> key;
            student temp;
            temp.linearsearch(s, n, key);
            break;
        }
        case 4:
        {
            cout << "BINARY SEARCH\n\n";
            string find_name;
            student temp;
            cout << "Name,you want to search : ";
            cin >> find_name;
            temp.binarysearch(s, n, find_name);
            break;
        }
        case 5:
        {
            cout << "BUBBLE SORT\n\n";
            student temp;
            temp.bubblesort(s, n);
            break;
        }
        case 6:
        {
            cout << " INSERTION SORT\n\n";
            student temp;
            temp.insertionSort(s, n);
            break;
        }
        case 7:
        {
            cout << "QUICK SORT\n\n";
            student temp;
            temp.quicksort(s, 0, n - 1);
            temp.putdata_qs(s, n);
        }
        }
        bool continu;
        cout << "ENTER 1: IF U WANT TO CONTINUE OPERATIONS: ";
        cin >> continu;
        if (continu != 1)
            break;
    }

    return 0;
}
