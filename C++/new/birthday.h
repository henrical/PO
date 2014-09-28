#ifndef BIRTHDAY_H
#define BIRTHDAY_H


class Birthday {
	public:
		Birthday(int d, int m, int y);
		std::string getFormattedDate();
	protected:
	private:
		int month;
		int day;
		int year;
};

#endif
