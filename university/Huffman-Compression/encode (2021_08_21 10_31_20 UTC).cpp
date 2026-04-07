#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <set>
#include <queue>

using namespace std;

map<char, int> Line;

string BinLine="";

string lines;

class TreeNode {
public:
	TreeNode* left = nullptr;
	TreeNode* right = nullptr;

	char value = '*';
	int frequency = -1;
};

TreeNode* root = new TreeNode;

struct comp1
{
	template<typename T>
	bool operator()(const T& l, const T& r) const
	{
		if (l.second != r.second)
			return l.second < r.second;

		return l.first < r.first;
	}
};

set<pair<char,int>, comp1> sets(Line.begin(), Line.end());

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

void encode(TreeNode* root, string str, map<char, string>& huffmanCode) {
	if (root == nullptr)
		return;

	if (!root->left && !root->right) {
		huffmanCode[root->value] = str;
		str = "";
	}

	encode(root->left, str + "0", huffmanCode);
	encode(root->right, str + "1", huffmanCode);
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

		Combined = merge(low1,low2);

		Huffman.push(Combined);
	}
	TreeNode* Last = Huffman.top();
	root = Last;
	map<char, string> huffmanCode;
	encode(root, "", huffmanCode);
	for (char ch : lines) {
		BinLine += huffmanCode[ch];
	}
}

void GetFrequency() {
	for (char c : lines) {
		if (Line.find(c) == Line.end()) {
			Line.insert({ c,1 });
		}
		else {
			Line[c]++;
		}
	}
	set<pair<char,int>, comp1> sets(Line.begin(), Line.end());
	for (auto& pair : sets) {
		cout << pair.first << " ";
	}
	cout << endl;
	for (auto& pair : sets) {
		cout << pair.second << " ";
	}
	cout << endl;
}

void GetOGBits() {
	int Total = 0;
	for (auto& pair : Line) {
		Total += pair.second;
	}
	Total = Total * 8;
	cout << "Total Bits (Original):" << Total << endl;
}

void GetCodeBits() {
	cout << "Total Bits (Coded):" <<BinLine.length() << endl;
}


int main() {
	getline(cin, lines);
	GetFrequency();
	MakeTree();
	cout << BinLine << endl;
	GetOGBits();
	GetCodeBits();
	return 0;
}