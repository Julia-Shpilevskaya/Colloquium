#include <gtest/gtest.h>
#include "FirstGroupOfQuestions.h"

TEST(ReverseList, test_reverse_ints)
{
	std::list<int> starter{ 1, 2, 3, 4, 5, 6 };
	std::list<int> result = ReverseList(starter);

	std::list<int> expected = { 6, 5, 4, 3, 2, 1 };

	for (std::list<int>::iterator iterExp = expected.begin(),
		iterRes = result.begin();
		iterExp != expected.end() || iterRes != result.end();
		++iterExp, ++iterRes)
	{
		EXPECT_EQ(*iterRes, *iterExp);
	}

}

TEST(IsPalindrome, test_123) {
	ASSERT_EQ(IsPalindrome(123), false);
}

TEST(IsPalindrome, test_123321)
{
	ASSERT_EQ(IsPalindrome(123321), true);
}

TEST(GetFibbonachi, test_5)
{
	int* result = GetFibbonachi(5);
	int expected[5]{ 1, 1, 2, 3, 5 };
	for (int i = 0; i < 5; i++)
	{
		EXPECT_EQ(expected[i], result[i]);
	}

	delete[] result;
}