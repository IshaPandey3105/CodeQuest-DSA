#include <iostream>
#include <fstream>
using namespace std;

void removeWhitespace(string& inputFile, string& outputFile) {
        ifstream inFile(inputFile);
        ofstream outFile(outputFile);
        if (!inFile) {
                cout<< "Error: Could not open the input file.\n";
        return;
        }
        if (!outFile) {
                cout<< "Error: Could not open the output file.\n";
                return;
        }
        char ch;
        while (inFile.get(ch)) {
                if (!isspace(static_cast<unsigned char>(ch))) {
                outFile.put(ch);
                }
        }
        cout << "Whitespace removal completed. Output stored in " << outputFile << ".\n";
        inFile.close();
        outFile.close();
}
int main() {
        string inputFile = "input.txt";
        string outputFile = "output.txt";
        removeWhitespace(inputFile, outputFile);
        return 0;
}