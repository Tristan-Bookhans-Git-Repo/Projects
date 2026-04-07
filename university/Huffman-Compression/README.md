# Huffman Compression — Encode & Decode

A command-line implementation of the Huffman coding compression algorithm in C++.

## What it does

Takes an input string and compresses it by assigning shorter binary codes to more frequent characters and longer codes to less frequent ones (Huffman coding). Includes both an encoder and a decoder as separate programs.

## Tech stack

- C++ (standard library: `iostream`, `map`, `set`, `queue`)
- No external dependencies

## How to run

**Compile:**
```bash
g++ encode.cpp -o encode
g++ decode.cpp -o decode
```

**Encode** (reads from stdin, outputs frequency table + binary string):
```bash
./encode
```

**Decode** (reads frequency pairs and binary string from stdin, outputs original text):
```bash
./decode
```

## Status

Academic exercise — complete.
