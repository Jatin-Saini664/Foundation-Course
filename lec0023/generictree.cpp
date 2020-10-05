#include <bits/stdc++.h>

using namespace std;

// class GenericTree
// {
class Node
{
public:
    int data;
    vector<Node *> child;
    Node(int data)
    {
        this->data = data;
    }
};

// public:
Node *root;
void construct(vector<int> &data)
{
    vector<Node *> cplist;
    // int size = sizeof(data) / sizeof(data[0]);
    for (int i = 0; i < data.size(); i++)
    {
        if (data[i] == -1 && cplist.back() == NULL)
            continue;
        if (data[i] == -1)
            cplist.pop_back();
        else
        {
            Node *nn;
            nn = new Node(data[i]);
            if (root == NULL)
            {
                root = nn;
            }
            else
            {
                Node *cn = cplist.back();
                cn->child.push_back(nn);
            }
            cplist.push_back(nn);
        }
    }
}

void display(Node *root)
{
    if (root == NULL)
        return;
    cout << root->data << " --> ";
    for (int i = 0; i < root->child.size(); i++)
    {
        cout << root->child[i]->data << ", ";
    }
    cout << "\n";
    for (int i = 0; i < root->child.size(); i++)
    {
        display(root->child[i]);
    }
}

void display2()
{
    display(root);
}
// };

int main()
{
    vector<int> arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 70, -1, 120, -1, -1, 90, -1, -1, 40, 100, 70};
    // GenericTree obj;
    // obj.construct(arr);
    // obj.display2();
    // obj.display(obj->root)
    construct(arr);
    display(root);
}