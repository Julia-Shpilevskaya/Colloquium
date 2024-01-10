﻿#include <iostream>
#include <thread>
#include <algorithm>
#include <mutex>
#include <fstream>
#include <string>
#include <vector>
#include <numeric>

std::mutex mtx;

void Thread(const std::string& directory, const int index)
{
	std::string file = directory + "in_" + std::to_string(index) + ".dat";
	std::vector<double> numbers;
	long double result = 0;
	int action;

	std::ifstream in(file);
	in >> action;

	while (!in.eof())
	{
		double temp;
		in >> temp;
		numbers.push_back(temp);
	}

	switch (action)
	{
	case 1:
		result = std::accumulate(numbers.begin(), numbers.end(), 0.0);
		break;
	case 2:
		result = std::accumulate(numbers.begin(), numbers.end(), 1.0, std::multiplies<double>());
		break;
	case 3:
		result = std::accumulate(numbers.begin(), numbers.end(), 0.0, [](double accumulator, double number) {
			return accumulator + (number * number);
			});
		break;
	default:
		break;
	}

	std::ofstream out(directory + "out.dat", std::ios::app);
	mtx.lock();

	if (out.is_open()) {
		out << "Result of thread" << std::to_string(index) << ": " << result << "\n";
		out.close();

		std::cout << "The value by thread" + std::to_string(index) + " was successfully written to the file." << "\n";
	}
	else {
		std::cout << "The file could not be opened for writing." << "\n";
	}

	mtx.unlock();
}

int main()
{
	int n;
	std::cout << "Enter count of threads: ";
	std::cin >> n;

	std::vector<std::thread> tvec;
	std::string directory = "C:/Users/Julia/OneDrive/Рабочий стол/Новая папка/ConsoleApplication1/";

	for (size_t i = 0; i < n; i++)
	{
		tvec.emplace_back(Thread, std::ref(directory), i + 1);
	}

	for (size_t i = 0; i < n; i++)
	{
		tvec[i].join();
	}

	return 0;
}