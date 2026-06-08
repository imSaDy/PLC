#!/bin/bash

# مسیر پوشه‌ها
OUTPUT_DIR="output"
SAMPLES_DIR="samples"

echo "🚀 Starting Output Comparison..."
echo "=================================================="

# حلقه روی اعداد ۱ تا ۸ (تعداد سمپل‌ها)
for i in {1..8}; do
    actual_file="$OUTPUT_DIR/out${i}.out"
    expected_file="$SAMPLES_DIR/sample${i}.out"

    # بررسی وجود فایل خروجی شما
    if [ ! -f "$actual_file" ]; then
        echo "⚠️  Skipping Test $i: Actual output ($actual_file) not found."
        continue
    fi

    # بررسی وجود فایل خروجی مورد انتظار
    if [ ! -f "$expected_file" ]; then
        echo "⚠️  Skipping Test $i: Expected output ($expected_file) not found."
        continue
    fi

    # مقایسه دو فایل و نادیده گرفتن تفاوت‌های مربوط به فاصله خطوط (CRLF/LF)
    DIFF=$(diff -u --strip-trailing-cr "$actual_file" "$expected_file")

    if [ -z "$DIFF" ]; then
        echo "✅ Test $i : PASSED"
    else
        echo "❌ Test $i : FAILED"
        echo "--- Differences ---"
        echo "$DIFF"
        echo "-------------------"
    fi
done

echo "=================================================="
echo "Done!"