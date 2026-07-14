# Movie Recommendation System

A Java desktop application that generates personalized movie recommendations using a Heap-Based Collaborative Filtering approach. The system identifies users with similar preferences through the Cosine Similarity algorithm and efficiently retrieves the most relevant users using a Max Heap.

## Overview

This project was developed as part of a Data Structures course to demonstrate the practical use of data structures and recommendation algorithms.

The application analyzes user rating data, computes similarity scores between users, and recommends highly rated movies from users with similar preferences. It also allows recommendations based on ratings entered by a new user through a Java Swing graphical interface.

## Features

- Heap-Based Collaborative Filtering
- Cosine Similarity algorithm
- Max Heap implementation
- Java Swing graphical user interface
- Recommendations for existing users
- Recommendations based on user-provided ratings
- CSV data processing
- Input validation

## Technologies

- Java
- Java Swing
- HashMap
- ArrayList
- Max Heap
- Cosine Similarity
- Object-Oriented Programming

## Project Structure

```text
src/
└── movierecommendationsystem/
    ├── Main.java
    ├── MovieSystem.java
    ├── MovieDataLoader.java
    ├── MovieDataSet.java
    ├── RecommendationEngine.java
    ├── CosineSimilarity.java
    ├── MaxHeap.java
    ├── HeapNode.java
    └── UserVector.java
```

## Recommendation Workflow

1. Load movie and user rating datasets.
2. Calculate similarity scores using the Cosine Similarity algorithm.
3. Store similarity values in a Max Heap.
4. Retrieve the most similar users.
5. Recommend the highest-rated movies.

## Future Improvements

- Hybrid recommendation techniques
- Database integration
- Performance optimization for large datasets
- Advanced filtering options
- Web-based version

## Author

**Sevde Zeynep Sütçü**

Software Engineering Student
