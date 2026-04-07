#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <queue>
#include<vector>

using namespace std;

string Ch,Val,Binline;

map<string, int> Line;

vector<string> Characters;
vector<int>frequent;

class TreeNode {
public:
	TreeNode* left = nullptr;
	TreeNode* right = nullptr;

	string value = "*";
	int frequency = -1;
};

TreeNode* root = new TreeNode;

class comp {
public:
	bool operator() (const TreeNode* one, const TreeNode* two) {
		return one->frequency > two->frequency;
	}
};

TreeNode* merge(TreeNode* t1, TreeNode* t2) {
	// Return a new node with t1 and t2 as children
	TreeNode* output = new TreeNode();
	output->frequency = t1->frequency + t2->frequency;
	output->left = t1;
	output->right = t2;
	// Fill this out

	return output;
}

void decode(TreeNode* root, int& index, string Binline)
{
	if (root == nullptr) {
		return;
	}
	if (!root->left && !root->right)
	{
		cout << root->value;
		return;
	}

	index++;

	if (Binline[index] == '0')
		decode(root->left, index, Binline);
	else
		decode(root->right, index, Binline);
}

void MakeTree() {
	priority_queue<TreeNode*, vector<TreeNode*>, comp > Huffman;

	for (auto& pair : Line) {
		TreeNode* n = new TreeNode;
		n->frequency = pair.second;
		n->value = pair.first;
		Huffman.push(n);
	}

	TreeNode* Combined = new TreeNode;

	while (Huffman.size() != 1) {
		TreeNode* low1 = Huffman.top();
		Huffman.pop();
		TreeNode* low2 = Huffman.top();
		Huffman.pop();

		Combined = merge(low1, low2);

		Huffman.push(Combined);
	}
	TreeNode* Last = Huffman.top();
	root = Last;

	int index = -1;
	while (index < (int)Binline.size() - 2) {
		decode(root, index, Binline);
	}
}

bool is_numeric(char s)
{
	int i = s - 48;
	if (i < 10 && i >= 0) {
		return true;
	}
	return false;
}

void MakeMap() {
	int Chvalues = Ch.length();
	for (int i = 0;i < Chvalues;i = i + 2) {
		string c = Ch[i];
		Characters[i]=c;
	}
	int j=0;
	while(j<Val.length()){
		if (j+1<=Val.length()){
			if (is_numeric(Val[j])){
				if (is_numeric(Val[j+1]) && ){
				int num = ((Val[j])-48)*10+((Val[j+1])-48)
					frequent[j]= num;
				}else{
					int num = Val[i] - 48;
					frequent[j] = num;
				}
			}
		}
		
	}
	int values = Val.length();
	for (int i = 0;i < values;i = i + 2) {
		string c = Ch[i];
		int num = Val[i] - 48;
		Line.insert({ c,num });
	}
	MakeTree();
}

int main() {
	getline(cin,Ch);
	getline(cin,Val);
	getline(cin,Binline);
	string use , less;
	getline(cin,use);
	getline(cin,less);
	MakeMap();	
	return 0;
}