#pragma once
#include <list>


template<class T>
std::list<T> ReverseList(std::list<T>& starterList)
{
	std::list<T> reversed;

	std::list<T>::iterator iter = starterList.end();
	iter--;

	for (; iter != starterList.begin(); iter--)
	{
		reversed.push_back(*iter);
	}

	reversed.push_back(*starterList.begin());

	return reversed;
}

int ReverseNum(int num)
{
	int reversed = 0;
	while (num)
	{
		reversed = reversed * 10 + num % 10;
		num /= 10;
	}

	return reversed;
}

bool IsPalindrome(int num)
{
	if (num < 0)
	{
		return false;
	}

	return num == ReverseNum(num);
}

int* GetFibbonachi(int n)
{
	if (n <= 0)
	{
		return nullptr;
	}

	if (n == 1)
	{
		return new int(1);
	}

	int* fibboContainer = new int[n];

	fibboContainer[0] = 1;
	fibboContainer[1] = 1;
	for (int i = 2; i < n; i++)
	{
		fibboContainer[i] = fibboContainer[i - 1] + fibboContainer[i - 2];
	}

	return fibboContainer;
}
